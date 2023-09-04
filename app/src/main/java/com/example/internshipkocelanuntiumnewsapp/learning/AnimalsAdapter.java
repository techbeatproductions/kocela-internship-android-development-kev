package com.example.internshipkocelanuntiumnewsapp.learning;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internshipkocelanuntiumnewsapp.R;

import java.util.ArrayList;

public class AnimalsAdapter extends BaseAdapter {
    Context context;
    ArrayList<Animals> animalsArrayList = new ArrayList<>();
    LayoutInflater inflter;

    public AnimalsAdapter(Context applicationContext, ArrayList<Animals> animalsArrayList) {
        this.context = context;
        this.animalsArrayList = animalsArrayList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return animalsArrayList.size();
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
        view = inflter.inflate(R.layout.animal_item_design, null);
        TextView tvAnimalName = (TextView) view.findViewById(R.id.name);
        ImageView imgAnimal = (ImageView) view.findViewById(R.id.img);
        tvAnimalName.setText(animalsArrayList.get(i).animalName);
//        imgAnimal.setImageResource(animalsArrayList.get(i).animalImg);
        return view;
    }

}