package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internshipkocelanuntiumnewsapp.R;

public class create_new_password extends AppCompatActivity {

    Button createPswdBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_password);
        getSupportActionBar().hide();

        createPswdBtn = (Button) findViewById(R.id.create_new_password_button);
        OnClickListeners();
    }

    private void OnClickListeners(){
        createPswdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(create_new_password.this, verification.class));
            }
        });
    }
}