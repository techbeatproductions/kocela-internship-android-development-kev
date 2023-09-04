package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internshipkocelanuntiumnewsapp.R;

public class Forgot_Password extends AppCompatActivity {

    Button frgtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        frgtPassword = (Button) findViewById(R.id.next_forgot_btn);
        OnClickListeners();
    }

    private void OnClickListeners(){
        frgtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Forgot_Password.this, create_new_password.class));
            }
        });
    }
}