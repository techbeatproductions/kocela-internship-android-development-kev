package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internshipkocelanuntiumnewsapp.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class select_your_favorite_topics extends AppCompatActivity{


    private Button[] buttons;
    private Button nextBtn;
    private List<Button> selectedButtons = new ArrayList<>();
    ArrayList<Integer> selectedButtonIds = new ArrayList<>();
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_favorite_topics);
        getSupportActionBar().hide();


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

        nextBtn = (Button) findViewById(R.id.next_fav_topic_button);

        setButtonClickListeners();
    }

    private void setButtonClickListeners() {
        for (final Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggleButtonSelection(button);

                }
            });
        }

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(select_your_favorite_topics.this, NewsActivity.class);
                intent.putIntegerArrayListExtra("selectedButtonIds",selectedButtonIds);

                startActivity(intent);



            }
        });
    }

    public void toggleButtonSelection(Button button){
        int index = selectedButtons.indexOf(button);

        if(index >= 0){
            //Button is selected, so deselect it
            selectedButtons.remove(button);
            button.setBackgroundResource(R.drawable.rounded_corner_view);
            button.setTextColor(getColor(R.color.gray_darker));


        } else {
            //Button is not selected so select it
            selectedButtons.add(button);
            button.setBackgroundResource(R.drawable.roundshapebutton);
            button.setTextColor(getColor(R.color.white));




        }
    }

    private void saveButtonState(int buttonId, boolean isSelected){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(String.valueOf(buttonId), isSelected);
        editor.commit();
    }


}