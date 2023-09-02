package com.example.internshipkocelanuntiumnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    ListView newsListView;
    ArrayList<News> nuntiumNews = new ArrayList<>();
    Button newsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        newsListView = (ListView) findViewById(R.id.news_list_view);

        NewsAdapter newsAdapter = new NewsAdapter(this, nuntiumNews);
        newsListView.setAdapter(newsAdapter);

        newsBtn = (Button) findViewById(R.id.random_news_button);

        getNews();
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

    void getNews(){
        NewsApiClient newsApiClient = new NewsApiClient("7c999e7db25f4894b27af4a416401509");
        // /v2/everything
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("trump")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        System.out.println(response.getArticles().get(0).getTitle());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    }
}