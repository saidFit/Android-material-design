package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private ImageView iv;
    private TextView tv;
    private TextInputLayout username,password;
    private Button GO;
    private Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // create Hooks;
        iv = findViewById(R.id.imageView2);
        tv = findViewById(R.id.textView);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        GO = findViewById(R.id.button_go);
        signup = findViewById(R.id.button_signUp);


    }

    public void launchToProfile(View v){
        startActivity(new Intent(this,ProfileActivity.class));
    }
    public void launchToRegister(View view){
        Intent i = new Intent(this,RegisterActivity.class);
        Pair[] pairs = new Pair[6];
        pairs[0] = new Pair< View,String >(iv,"logo_img");
        pairs[1] = new Pair<View,String>(tv,"logo_text");
         pairs[2] = new Pair<View,String>(GO,"button_GO");
         pairs[3] = new Pair<View,String>(username,"EditText_field_username");
         pairs[4] = new Pair<View,String>(username,"EditText_field_password");
         pairs[5] = new Pair<View,String>(signup,"signUp_button");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,pairs);
        startActivity(i,options.toBundle());



    }
}