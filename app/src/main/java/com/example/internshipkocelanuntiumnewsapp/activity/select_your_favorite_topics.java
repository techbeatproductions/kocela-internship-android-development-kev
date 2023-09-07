package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.internshipkocelanuntiumnewsapp.R;

import java.util.ArrayList;
import java.util.List;

public class select_your_favorite_topics extends AppCompatActivity{

    private Button[] buttons;
    private Button nextBtn;
    private List<Button> selectedButtons = new ArrayList<>();
    ArrayList<Integer> selectedButtonIds = new ArrayList<>();

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

                    //Update selected Button Ids based on selectedButtons
                    selectedButtonIds.clear(); //clear the list to rebuild it
                    for (Button selectedButton: selectedButtons) {
                        selectedButtonIds.add(selectedButton.getId());
                    }

                    // Log whether the button is selected and the selectedButtonIds
                    Log.d("ButtonSelection", button.getText().toString() + " is selected: " + button.isSelected());
                    Log.d("SelectedButtonIds", "SelectedButtonIds: " + selectedButtonIds.toString());

                }
            });

            // Set all buttons to unselected initially
            button.setSelected(false);
            button.setBackgroundResource(R.drawable.rounded_corner_view);
            button.setTextColor(getColor(R.color.gray_darker));
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
        // Manually toggle the selection state
        button.setSelected(!button.isSelected());

        // Update the appearance based on the new selection state
        if (button.isSelected()) {
            button.setBackgroundResource(R.drawable.roundshapebutton);
            button.setTextColor(getColor(R.color.white));
            selectedButtons.add(button);
        } else {
            button.setBackgroundResource(R.drawable.rounded_corner_view);
            button.setTextColor(getColor(R.color.gray_darker));
            selectedButtons.remove(button);
        }
    }
}