package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internshipkocelanuntiumnewsapp.R;

public class WelcomeScreen extends AppCompatActivity {

    Button getStarted_welcome_screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        getStarted_welcome_screen = (Button)findViewById(R.id.get_started_button_welcome_screen);

        onclicklisteners();

    }

    private void onclicklisteners() {

        getStarted_welcome_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeScreen.this, SignIn.class));
            }
        });


    }
}