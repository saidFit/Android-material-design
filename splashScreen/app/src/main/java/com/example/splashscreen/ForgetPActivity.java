package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ForgetPActivity extends AppCompatActivity {

    private View parentForgetP;
    private Animation forgetAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pactivity);
        parentForgetP = findViewById(R.id.parentForgetP);
        forgetAnim = AnimationUtils.loadAnimation(this,R.anim.forget_password_animate);
        parentForgetP.setAnimation(forgetAnim);
    }

    public void launchToSelectTypeSms(View v){
        startActivity(new Intent(this,SelectOptionActivity.class));
        // Remove transition animation
        overridePendingTransition(0, 0);
    }
}