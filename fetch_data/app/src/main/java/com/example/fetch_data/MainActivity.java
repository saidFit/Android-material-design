package com.example.fetch_data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_URL = "https://run.mocky.io/v3/9b76c97d-6f5d-493c-8408-1a8597967178";

    List<ActorModel> actorList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actorList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);

        GetData getData = new GetData();
        getData.execute();
    }


    public class GetData extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String... strings) {

            String current= "";

            try {
                URL url;
                HttpURLConnection httpURLConnection = null;
                try {
                    url = new URL(JSON_URL);
                    httpURLConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = httpURLConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();

                    while(data != -1){
                        current += (char) data;
                        data = isr.read();
                    }

//                    return current;


                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }finally {
                    if(httpURLConnection != null){
                        httpURLConnection.disconnect();
                    }
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }

            return current;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray   = jsonObject.getJSONArray("actors");

                for (int i = 0 ; i < jsonArray.length() ; i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    ActorModel actor = new ActorModel();
                    actor.setId(jsonObject1.getString("id"));
                    actor.setName(jsonObject1.getString("name"));
                    actor.setOverView(jsonObject1.getString("overview"));
                    actor.setImg(jsonObject1.getString("image"));

                    actorList.add(actor);


                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            putDataIntoRecyclerView(actorList);
        }
    }
    private void putDataIntoRecyclerView(List<ActorModel> actorList){
        ActorsAdapter actorsAdapter = new ActorsAdapter(this,actorList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(actorsAdapter);
    }
}