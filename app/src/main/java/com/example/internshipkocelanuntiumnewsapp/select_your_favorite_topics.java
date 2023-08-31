package com.example.internshipkocelanuntiumnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class select_your_favorite_topics extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_favorite_topics);

        bt1 = (Button) findViewById(R.id.sports_topic_button);
        bt2 = (Button) findViewById(R.id.politics_topic_button);
        bt3 = (Button) findViewById(R.id.life_topic_button);
        bt4 = (Button) findViewById(R.id.gaming_topic_button);
        bt5 = (Button) findViewById(R.id.animals_topic_button);
        bt6 = (Button) findViewById(R.id.nature_topic_button);
        bt7 = (Button) findViewById(R.id.food_topic_button);
        bt8 = (Button) findViewById(R.id.art_topic_button);
        bt9 = (Button) findViewById(R.id.history_topic_button);
        bt10 = (Button) findViewById(R.id.fashion_topic_button);

        onClickListeners();
    }

    private void onClickListeners(){

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });
    }
}