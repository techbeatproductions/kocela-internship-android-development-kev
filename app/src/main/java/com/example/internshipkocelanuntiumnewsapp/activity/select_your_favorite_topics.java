package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internshipkocelanuntiumnewsapp.R;

public class select_your_favorite_topics extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_favorite_topics);

        nextBtn = (Button) findViewById(R.id.next_fav_topic_button);
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


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_your_favorite_topics.this, NewsActivity.class));
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               bt1.setBackgroundResource(R.drawable.roundshapebutton);
                bt1.setTextColor(getColor(R.color.white));
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt2.setBackgroundResource(R.drawable.roundshapebutton);
                bt2.setTextColor(getColor(R.color.white));
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt3.setBackgroundResource(R.drawable.roundshapebutton);
                bt3.setTextColor(getColor(R.color.white));
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt4.setBackgroundResource(R.drawable.roundshapebutton);
                bt4.setTextColor(getColor(R.color.white));
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt5.setBackgroundResource(R.drawable.roundshapebutton);
                bt5.setTextColor(getColor(R.color.white));
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt6.setBackgroundResource(R.drawable.roundshapebutton);
                bt6.setTextColor(getColor(R.color.white));
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt7.setBackgroundResource(R.drawable.roundshapebutton);
                bt7.setTextColor(getColor(R.color.white));
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt8.setBackgroundResource(R.drawable.roundshapebutton);
                bt8.setTextColor(getColor(R.color.white));
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt9.setBackgroundResource(R.drawable.roundshapebutton);
                bt9.setTextColor(getColor(R.color.white));
            }
        });

        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt10.setBackgroundResource(R.drawable.roundshapebutton);
                bt10.setTextColor(getColor(R.color.white));
            }
        });
    }
}