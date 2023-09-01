package com.example.internshipkocelanuntiumnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewDemo extends AppCompatActivity {

    ListView animalListView;
    ArrayList<String> animals = new ArrayList<>();

    ArrayList <Animals> myAnimals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        animalListView = findViewById(R.id.animalListView);
        String a = "Giraffe";
        animals.add(a);
        animals.add("Lion");

        Animals anim = new Animals("none", "Elephant");

        myAnimals.add(anim);

        AnimalsAdapter animalsAdapter = new AnimalsAdapter(this, myAnimals);
        animalListView.setAdapter(animalsAdapter);

    }
}