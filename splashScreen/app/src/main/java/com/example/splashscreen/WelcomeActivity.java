package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }


    public void launchToLoginRetailer(View v){
        Intent i = new Intent(this,Login_retailer.class);

        Pair[] pairs= new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.login_btn),"transition_login");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,pairs);
        startActivity(i,options.toBundle());


    }

    public void launchToRegisterRetailer(View v){
        Intent i = new Intent(this,SignUpActivity.class);

        Pair[] pairs= new Pair[2];
        pairs[0] = new Pair<View,String>(findViewById(R.id.register_btn),"transition_register");
        pairs[1] = new Pair<View,String>(findViewById(R.id.welcome_activity),"transition_welcome_activity");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,pairs);
        startActivity(i,options.toBundle());


    }


}