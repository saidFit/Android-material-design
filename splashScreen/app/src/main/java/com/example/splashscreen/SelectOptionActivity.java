package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SelectOptionActivity extends AppCompatActivity {
    private View parentSelectOption;
    private Animation forgetAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option);
        parentSelectOption = findViewById(R.id.parentSelectOption);
        forgetAnim = AnimationUtils.loadAnimation(this,R.anim.forget_password_animate);
        parentSelectOption.setAnimation(forgetAnim);
    }


}