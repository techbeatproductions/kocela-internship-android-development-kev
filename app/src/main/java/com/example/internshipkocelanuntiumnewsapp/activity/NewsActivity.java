package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.internshipkocelanuntiumnewsapp.Models.News;
import com.example.internshipkocelanuntiumnewsapp.adapter.NewsAdapter;
import com.example.internshipkocelanuntiumnewsapp.R;


import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    ListView newsListView;
    ArrayList<News> nuntiumNews = new ArrayList<>();

    NewsAdapter newsAdapter;
    Button newsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //Instantiate the news adapter
        newsAdapter = new NewsAdapter(this, nuntiumNews);


        //Get the ListView and attach the adapter
        newsListView = findViewById(R.id.news_list_view);

        News n = new News("none", "Test 1", "none","none", "none", "none", "none");
        News n2 = new News("none", "Test 2", "none","none", "none", "none", "none");
        News n3 = new News("none", "Test 3", "none","none", "none", "none", "none");
        News n4 = new News("none", "Test 4", "none","none", "none", "none", "none");

        nuntiumNews.add(n);
        nuntiumNews.add(n2);
        nuntiumNews.add(n3);
        nuntiumNews.add(n4);



        newsListView.setAdapter(newsAdapter);

        newsBtn = (Button) findViewById(R.id.random_news_button);

        onClickListeners();

    }






    private void onClickListeners(){
        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewsActivity.this, articles.class));


            }
        });
    }


}