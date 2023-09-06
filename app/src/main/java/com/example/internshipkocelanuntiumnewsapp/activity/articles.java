package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internshipkocelanuntiumnewsapp.R;
import com.squareup.picasso.Picasso;

public class articles extends AppCompatActivity {

    String title;
    String url;
    String image_url;
    String content;
    String author;
    ImageView news_img_article, back_button, share_button;
    TextView news_article_author,news_article_content,news_article_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articles);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        image_url = intent.getStringExtra("image");
        content = intent.getStringExtra("content");
        author = intent.getStringExtra("author");
        url = intent.getStringExtra("url");


        news_article_author = findViewById(R.id.author_name_txt_view);
        news_article_content = findViewById(R.id.full_article_txt_view);
        news_article_title = findViewById(R.id.news_headline_txt_view);
        news_img_article= findViewById(R.id.article_img_actual);
        back_button = findViewById(R.id.back_button_with_icon);
        share_button = findViewById(R.id.share_button_with_icon);

        news_article_title.setText(title);
        news_article_content.setText(content);
        news_article_author.setText(author);
        Picasso.get().load(image_url).into(news_img_article);

        onClickListeners();
    }

    private void onClickListeners (){
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(articles.this, NewsActivity.class));
            }
        });

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, url);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }
}

