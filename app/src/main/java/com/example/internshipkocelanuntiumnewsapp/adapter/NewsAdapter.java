package com.example.internshipkocelanuntiumnewsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internshipkocelanuntiumnewsapp.Models.News;
import com.example.internshipkocelanuntiumnewsapp.R;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<News> newsArrayList ; //data source of the list adapter



    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @Override
    public int getCount() {
        return newsArrayList.size(); // returns total of news in the list
    }

    @Override
    public Object getItem(int i) {
        return newsArrayList.get(i); //returns list item at the specified position
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup parent) {




        //inflate the layout for each list row
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.news_item_design,parent, false);
        }

        //get current news to be displayed
        News currentNews = (News)getItem(i);

        //get the TextView for headline
        TextView tvNewsHeadline = view.findViewById(R.id.news_title_holder);

        //get the News image
        ImageView imgNews = view.findViewById(R.id.news_image_holder);

        // Getting news from News Api
        NewsApiClient newsApiClient = new NewsApiClient("7c999e7db25f4894b27af4a416401509");

        // /v2/everything
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("trump")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {

                    @Override
                    public void onSuccess(ArticleResponse response) {



                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );



        //set the text for headline fom the current object
        tvNewsHeadline.setText(currentNews.getTitle());

        //Set image
        Picasso.get().load(currentNews.getUrlToImage()).into(imgNews);


        return view;
    }

    private void getNews(){


    }
}