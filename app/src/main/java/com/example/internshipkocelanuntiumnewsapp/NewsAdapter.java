package com.example.internshipkocelanuntiumnewsapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class NewsAdapter extends BaseAdapter {
    Context context;
    ArrayList<News> newsArrayList ;



    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @Override
    public int getCount() {
        return newsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return newsArrayList.get(i);
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
        TextView tvNewsHeadline = (TextView) view.findViewById(R.id.news_title_holder);

        //get the News image
        ImageView imgNews = (ImageView) view.findViewById(R.id.news_image_holder);

        //set the text for headline fom the current object
        tvNewsHeadline.setText(newsArrayList.get(i).getHeadline());

        //Set image
        Picasso.get().load(newsArrayList.get(i).getUrlToImage()).into(imgNews);


        return view;
    }
}