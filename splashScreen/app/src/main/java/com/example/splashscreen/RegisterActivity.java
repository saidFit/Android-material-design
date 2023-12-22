
package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private ImageView iv;
    private TextView tv;
    private TextInputLayout username_field,password,email,fullName,phoneNo;
    private Button GO;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // create Hooks;
        iv = findViewById(R.id.imageView2);
        tv = findViewById(R.id.textView);
        username_field = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email    = findViewById(R.id.email);
        fullName = findViewById(R.id.fullName);
        phoneNo  = findViewById(R.id.phoneNo);
        GO = findViewById(R.id.button_go);
        signup = findViewById(R.id.button_signUp);
    }




    public boolean validateUsername(String username){
        System.out.println(username);
        if(username != null && !username.isEmpty() && (username.length() >=3 && username.length() <= 12)){

               for(char c : username.toCharArray()){
                   // Check if the username consists of valid characters (letters, digits, and underscore)
                   if (!Character.isLetterOrDigit(c) && c != '_') {
                       username_field.setError("name aren't have special char or spaces");
                       return false;
                   }
               }

            username_field.setError(null);
            return true;
        }
        username_field.setError("name shouldn't be empty and less than 3 and great than 12");
        return false;

    }

    public void register(View view){

        if(!validateUsername(username_field.getEditText().getText().toString())){
            return;
        }
        Log.d("register","valid registration");
    }

    public void launchToLogin(View v){
        Intent i = new Intent(this,LoginActivity.class);
        Pair[] pairs = new Pair[6];
        pairs[0] = new Pair< View,String >(iv,"logo_img");
        pairs[1] = new Pair<View,String>(tv,"logo_text");
        pairs[2] = new Pair<View,String>(GO,"button_GO");
        pairs[3] = new Pair<View,String>(username_field,"EditText_field_username");
        pairs[4] = new Pair<View,String>(username_field,"EditText_field_password");
        pairs[5] = new Pair<View,String>(signup,"signUp_button");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,pairs);
        startActivity(i,options.toBundle());
    }
}