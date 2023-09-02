package com.example.internshipkocelanuntiumnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    Button signUpBtn;
    LinearLayout signInTxt;
    EditText username,email, new_pass, repeat_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpBtn = (Button) findViewById(R.id.sign_up_button);
        signInTxt = (LinearLayout) findViewById(R.id.sign_in_container);

        username = (EditText) findViewById(R.id.sign_up_user_name_editTextText);
        email = (EditText) findViewById(R.id.sign_up_editTextTextEmailAddress);
        new_pass = (EditText) findViewById(R.id.sign_up_newTextPassword);
        repeat_pass = (EditText) findViewById(R.id.sign_up_repeatnewTextPassword);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() > 0){
                    username.setTextColor(getColor(R.color.gray_darker));
                    username.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    username.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.user_sign_up_typing,0,0,0);

                    email.setTextColor(getColor(R.color.gray_darker));
                    email.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope_typing_state,0,0,0);

                    new_pass.setTextColor(getColor(R.color.gray_darker));
                    new_pass.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    new_pass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock_typing_state,0,0,0);

                    repeat_pass.setTextColor(getColor(R.color.gray_darker));
                    repeat_pass.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    repeat_pass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock_typing_state,0,0,0);

                } else {
                    username.setTextColor(getColor(R.color.gray_darker));
                    username.setBackgroundResource(R.drawable.rounded_corner_view);
                    username.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.user,0,0,0);

                    email.setTextColor(getColor(R.color.gray_darker));
                    email.setBackgroundResource(R.drawable.rounded_corner_view);
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope,0,0,0);

                    new_pass.setTextColor(getColor(R.color.gray_darker));
                    new_pass.setBackgroundResource(R.drawable.rounded_corner_view);
                    new_pass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock,0,0,0);

                    repeat_pass.setTextColor(getColor(R.color.gray_darker));
                    repeat_pass.setBackgroundResource(R.drawable.rounded_corner_view);
                    repeat_pass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock,0,0,0);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        OnClickListeners();
    }

    private void OnClickListeners(){
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, select_your_favorite_topics.class));
            }
        });

        signInTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, SignIn.class));
            }
        });
    }
}