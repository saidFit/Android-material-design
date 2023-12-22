package com.example.splashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.splashscreen.SliderAdapter.Card;
import com.example.splashscreen.SliderAdapter.SliderAdapter;

import java.util.ArrayList;

public class User_dashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);

        NestedScrollView nestedScrollView = findViewById(R.id.nestedScrollView);

        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                System.out.println(scrollY+" "+oldScrollX);
                if (scrollY > oldScrollY) {
                    // Scrolling down
                    relativeLayout.setElevation(50); // Set your desired elevation
                } else {
                    // Scrolling up
                    relativeLayout.setElevation(0); // Reset elevation to 0
                }
            }
        });


        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(R.drawable.bathrobe,"bathrobe","this bathrobe has a lot of characters might be beauty in the word."));
        cards.add(new Card(R.drawable.coffee_machine,"coffee_machine","this coffee_machine has a lot of characters might be beauty in the word."));
        cards.add(new Card(R.drawable.hoddie,"hoddie","this hoddie has a lot of characters might be beauty in the word."));

        // Inside your activity
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);


        RecyclerView recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView1.setLayoutManager(layoutManager);
        SliderAdapter adapter = new SliderAdapter(this, cards);
        recyclerView1.setAdapter(adapter);



//        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager1);
//
//        SliderAdapter adapter1 = new SliderAdapter(this, cards);
//        recyclerView.setAdapter(adapter1);
//        recyclerView1.setAdapter(adapter1);

    }

    public void launchToWelcome(View v){
        startActivity(new Intent(this,WelcomeActivity.class));
    }


}
