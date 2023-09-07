package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.internshipkocelanuntiumnewsapp.Models.News;
import com.example.internshipkocelanuntiumnewsapp.adapter.NewsAdapter;
import com.example.internshipkocelanuntiumnewsapp.R;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity  {

    ListView newsListView;
    EditText search;
    NewsAdapter newsAdapter;
    ImageView search_button_img;
    private Button[] buttons;
    private Button randomNewsButton;

    ArrayList<Integer> selectedButtonIds = new ArrayList<>();


    ArrayList<News> newsList = new ArrayList<>();
    String defaultSearchTerm = "technology";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("NewsActivity", "onCreate called");
        setContentView(R.layout.activity_news);
        getSupportActionBar().hide();

        selectedButtonIds = getIntent().getIntegerArrayListExtra("selectedButtonIds");


        // Add a debug log to print the received selectedButtonIds
        if (selectedButtonIds != null) {
            for (int buttonId : selectedButtonIds) {
                Log.d("NewsActivity", "Received selectedButtonId: " + buttonId);
            }
        } else {
            Log.d("NewsActivity", "selectedButtonIds is null");
        }

        //Get the ListView and attach the adapter
        newsListView = findViewById(R.id.news_list_view);
        search = findViewById(R.id.search_editTextText);
        search_button_img = findViewById(R.id.search_btn);

        randomNewsButton = (Button) findViewById(R.id.random_news_button);

        buttons =  new Button[] {
                findViewById(R.id.sports_topic_button),
                findViewById(R.id.politics_topic_button),
                findViewById(R.id.life_topic_button),
                findViewById(R.id.gaming_topic_button),
                findViewById(R.id.animals_topic_button),
                findViewById(R.id.nature_topic_button),
                findViewById(R.id.food_topic_button),
                findViewById(R.id.art_topic_button),
                findViewById(R.id.history_topic_button),
                findViewById(R.id.fashion_topic_button)
        };

       loadButtonStates();





        onClickListeners();

        //Display technology news by default

        fetchNewsArticles(defaultSearchTerm);

    }

    private void loadButtonStates() {
        for (Button button : buttons) {
            int buttonId = button.getId();
            boolean isSelected = selectedButtonIds.contains(buttonId);
            button.setSelected(isSelected);

            Log.d("ButtonVisibility", button.getText().toString() + " is selected: " + isSelected);

            if (isSelected) {
                button.setVisibility(View.VISIBLE);
                fetchNewsArticles(button.getText().toString());
            } else {
                button.setVisibility(View.GONE);
            }
        }
    }








    private void fetchNewsArticles(String searchTerm){
        // Getting news from News Api
        NewsApiClient newsApiClient = new NewsApiClient("7c999e7db25f4894b27af4a416401509");


        //News Api integration
        // /v2/everything
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(searchTerm)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {

                    @Override
                    public void onSuccess(ArticleResponse response) {

                        newsList.clear();

                        for(Article article:response.getArticles()) {
                            String author = article.getAuthor();
                            String title = article.getTitle();
                            String imageUrl = article.getUrlToImage();
                            String content = article.getContent();
                            String url = article.getUrl();

                            if (!title.equals("[Removed]") && !title.isEmpty()) {
                                News news = new News(author, title, "", url, imageUrl, "", content);
                                newsList.add(news);
                            }
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

    public void toggleButtonSelection(Button button){
        int buttonId = button.getId();
        if (selectedButtonIds.contains(buttonId)) {
            // Button is selected, so deselect it
            selectedButtonIds.remove(Integer.valueOf(buttonId));
            button.setSelected(false);

        } else {
            // Button is not selected, so select it
            selectedButtonIds.add(buttonId);
            button.setSelected(true);
            // Fetch news articles based on the selected topic
            fetchNewsArticles(button.getText().toString());
        }
    }

    private void onClickListeners(){
        //Set an OnClickListener for search button
        search_button_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get the current search query from the search text
                String search_query = search.getText().toString();
                fetchNewsArticles(search_query);
            }
        });

        randomNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchNewsArticles(defaultSearchTerm);


            }
        });

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NewsActivity.this, articles.class);
                intent.putExtra("title", newsList.get(i).getTitle() );
                intent.putExtra("content", newsList.get(i).getContent());
                intent.putExtra("author", newsList.get(i).getAuthor());
                intent.putExtra("image",newsList.get(i).getUrlToImage());
                intent.putExtra("url", newsList.get(i).getUrl());

                startActivity(intent);
            }
        });

        // OnClickListener for each topic button
        for(Button button : buttons) {
            if (button.getVisibility() == View.VISIBLE)
            {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Get the text of the selected button
                        String selectedTopic = button.getText().toString();

                        //Fetch news articles based on the selected topic
                        fetchNewsArticles(selectedTopic);

                        //Update the selectedButtonIds and button state
                        toggleButtonSelection(button);
                    }
                });

            }




        }
    }


}