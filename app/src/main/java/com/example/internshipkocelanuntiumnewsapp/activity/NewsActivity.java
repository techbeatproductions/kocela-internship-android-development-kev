package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.internshipkocelanuntiumnewsapp.Models.News;
import com.example.internshipkocelanuntiumnewsapp.adapter.NewsAdapter;
import com.example.internshipkocelanuntiumnewsapp.R;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;


import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    ListView newsListView;
    EditText search;

    NewsAdapter newsAdapter;
    Button newsBtn;
    ArrayList<News> newsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        getSupportActionBar().hide();

        //Get the ListView and attach the adapter
        newsListView = findViewById(R.id.news_list_view);
        search = findViewById(R.id.search_editTextText);

        newsListView.setAdapter(newsAdapter);

        newsBtn = (Button) findViewById(R.id.random_news_button);

        onClickListeners();

        // Getting news from News Api
        NewsApiClient newsApiClient = new NewsApiClient("7c999e7db25f4894b27af4a416401509");

        //News Api integration
        // /v2/everything
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("artificial intelligence")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {

                    @Override
                    public void onSuccess(ArticleResponse response) {


                        for(Article article:response.getArticles()) {
                            String author = article.getAuthor();
                            String title = article.getTitle();
                            String imageUrl = article.getUrlToImage();
                            News news = new News(author,title,"","",imageUrl,"","");
                            newsList.add(news);
                        }

                        newsAdapter =  new NewsAdapter(NewsActivity.this, newsList);
                        newsListView.setAdapter(newsAdapter);



                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );








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