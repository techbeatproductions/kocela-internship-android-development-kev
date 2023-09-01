package com.example.internshipkocelanuntiumnewsapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class NewsAdapter extends BaseAdapter {
    Context context;
    ArrayList<News> newsArrayList = new ArrayList<>();

    LayoutInflater inflter;

    public NewsAdapter(Context applicationContext, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;


        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return newsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.news_item_design, null);

        TextView tvNewsHeadline = (TextView) view.findViewById(R.id.news_title_holder);
        ImageView imgNews = (ImageView) view.findViewById(R.id.news_image_holder);

        tvNewsHeadline.setText(newsArrayList.get(i).getHeadline());
       // imgNews.setImageResource(newsArrayList.get(i).);

        return view;
    }
}