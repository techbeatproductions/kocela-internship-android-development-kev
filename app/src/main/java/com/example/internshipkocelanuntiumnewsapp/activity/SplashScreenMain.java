package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.example.internshipkocelanuntiumnewsapp.R;

public class SplashScreenMain extends AppCompatActivity {

    Handler handler;
    private static final String PREF_NAME = "MySignedInPrefs";
    private static final String PREF_SIGNED_UP = "signed_up"; //Key for sign up status

    private static final long SPLASH_DELAY = 2000; // Splash screen delay
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_main);
        getSupportActionBar().hide();


        //Check if the user has signed up before



        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            //User has signed up, navigate to the News Activity
            Log.d("Splash Activity", "User has signed up before.");
            navigateToNewsActivity();
        } else {
            //User has not signed up, navigate to the Onboarding activity
            Log.d("Splash Activity", "User has not signed up before");
            navigateToOnboardingActivity();
        }




    }

    private void navigateToOnboardingActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(SplashScreenMain.this, Onboarding.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DELAY);
    }

    private void navigateToNewsActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(SplashScreenMain.this, SignIn.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DELAY);

    }

}