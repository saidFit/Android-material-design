package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    private TextView counterFragment;
    private int counter=0;
    @Override
    public void onBackPressed() { // this for when the user clicks the back button on the device(bottom-left click)
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (currentFragment instanceof SignUpFragment1 || currentFragment instanceof SignUpFragment2 || currentFragment instanceof SignUpFragment3) {
            // If the current fragment is one of the SignUpFragmentX fragments and counter is greater than 1, decrement it.
            if (counter > 1) {
                counter--;
                counterFragment.setText(counter + "/3");
            }
        }

        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        counterFragment = findViewById(R.id.counterFragment);

        if(savedInstanceState == null){
            counter=1;
            counterFragment.setText(counter+"/3");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,new SignUpFragment1())
                    .commit();

        }

        Button nextBtn = findViewById(R.id.nextButton);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

                if(currentFragment instanceof SignUpFragment1){
                     counter++;
                    counterFragment.setText(counter+"/3");

                    // Define shared elements for the transition
                    View fullNameView = findViewById(R.id.fullName_log);
                    View usernameView = findViewById(R.id.username);
                    View emailAddress = findViewById(R.id.emailAddress_log);
                    View password = findViewById(R.id.password_log);

                    // Set up shared element transitions
                    Fragment signUpFragment2 = new SignUpFragment2();
                    signUpFragment2.setSharedElementEnterTransition(new ChangeBounds());
                    signUpFragment2.setEnterTransition(new Fade());
                    signUpFragment2.setSharedElementReturnTransition(new ChangeBounds());

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, signUpFragment2)
                            .addToBackStack(null)
                            .addSharedElement(fullNameView, "fullName")
                            .addSharedElement(usernameView, "username")
                            .addSharedElement(emailAddress, "email")
                            .addSharedElement(password, "password")
                            .commit();

                }else if(currentFragment instanceof SignUpFragment2){
                    counter++;
                    counterFragment.setText(counter+"/3");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,new SignUpFragment3())
                            .addToBackStack(null)
                            .commit();

                }else {

                    startActivity(new Intent(SignUpActivity.this,ForgetPActivity.class));
                    finish();
                }

            }
        });
    }
}