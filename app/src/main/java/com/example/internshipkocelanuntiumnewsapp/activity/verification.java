package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internshipkocelanuntiumnewsapp.R;

public class verification extends AppCompatActivity {

    Button vrfBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        vrfBtn = (Button) findViewById(R.id.verificationsigninbutton);
        vrfBtnOnClickListener();
    }

    private void vrfBtnOnClickListener(){
        vrfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(verification.this, select_your_favorite_topics.class));
            }
        });
    }
}