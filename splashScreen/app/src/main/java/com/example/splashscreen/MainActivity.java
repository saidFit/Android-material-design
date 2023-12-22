package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // some variables;
    private static final int delayMillis = 2000;
    Animation topAnim,bottomAnim;
    TextView tv0,tv1;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        tv0 = findViewById(R.id.textView);
        tv1 = findViewById(R.id.textView2);
        iv = findViewById(R.id.imageView);

        tv0.setAnimation(bottomAnim);
        tv1.setAnimation(bottomAnim);
        iv.setAnimation(topAnim);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
              Intent i =  new Intent(MainActivity.this, LoginActivity.class);
                //This code initializes an array of Pair objects. Each Pair represents a shared element
                // transition, where the first element is the View in the source activity, and the second element is a string identifier for that view
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair< View,String >(iv,"logo_img");
                pairs[1] = new Pair<View,String>(tv0,"logo_text");
                //makeSceneTransitionAnimation method to specify that you want to apply scene
                // transitions with the shared elements defined in the pairs array.
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                //Finally, you start the DashboardActivity using the ActivityOptions you've configured. When this transition occurs
                startActivity(i,options.toBundle());
            }
        };

        // use Handler to post the delayed action
        handler.postDelayed(runnable,delayMillis);


    }
}