package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.internshipkocelanuntiumnewsapp.R;
import com.example.internshipkocelanuntiumnewsapp.utils.UserCreationTask;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity implements UserCreationTask.UserCreationCallback{

    Button signUpBtn;
    LinearLayout signInTxt;
    EditText username, email, new_pass, repeat_pass;
    SharedPreferences sharedPreferences;

    private UserCreationTask.UserCreationCallback userCreationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        signUpBtn = findViewById(R.id.sign_up_button);
        signInTxt = findViewById(R.id.sign_in_container);

        username = findViewById(R.id.sign_up_user_name_editTextText);
        email = findViewById(R.id.sign_up_editTextTextEmailAddress);
        new_pass = findViewById(R.id.sign_up_newTextPassword);
        repeat_pass = findViewById(R.id.sign_up_repeatnewTextPassword);

        // Initialize the callback
        userCreationCallback = this;

        // Prevent keyboard from showing up immediately
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() > 0) {
                    username.setTextColor(getColor(R.color.gray_darker));
                    username.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    username.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.user_sign_up_typing, 0, 0, 0);

                    email.setTextColor(getColor(R.color.gray_darker));
                    email.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope_typing_state, 0, 0, 0);

                    new_pass.setTextColor(getColor(R.color.gray_darker));
                    new_pass.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    new_pass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock_typing_state, 0, 0, 0);

                    repeat_pass.setTextColor(getColor(R.color.gray_darker));
                    repeat_pass.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    repeat_pass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock_typing_state, 0, 0, 0);

                } else {
                    username.setTextColor(getColor(R.color.gray_darker));
                    username.setBackgroundResource(R.drawable.rounded_corner_view);
                    username.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.user, 0, 0, 0);

                    email.setTextColor(getColor(R.color.gray_darker));
                    email.setBackgroundResource(R.drawable.rounded_corner_view);
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope, 0, 0, 0);

                    new_pass.setTextColor(getColor(R.color.gray_darker));
                    new_pass.setBackgroundResource(R.drawable.rounded_corner_view);
                    new_pass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock, 0, 0, 0);

                    repeat_pass.setTextColor(getColor(R.color.gray_darker));
                    repeat_pass.setBackgroundResource(R.drawable.rounded_corner_view);
                    repeat_pass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock, 0, 0, 0);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString())) {
                    username.setError("Please enter your username");
                    return;
                }
                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Please enter your email");
                    return;
                }
                if (!isValidEmail(email.getText().toString())) {
                    email.setError("Please enter a valid email");
                    return;
                }
                if (TextUtils.isEmpty(new_pass.getText().toString())) {
                    new_pass.setError("Please enter your password");
                    return;
                }
                if (TextUtils.isEmpty(repeat_pass.getText().toString())) {
                    repeat_pass.setError("Please repeat your password");
                    return;
                }
                if (!new_pass.getText().toString().equals(repeat_pass.getText().toString())) {
                    repeat_pass.setError("Passwords do not match");
                    return;
                }

                //Construct the JSON data for user creation
                String userData = "{\"firstName\":\"" + username.getText().toString() + "\", \"lastName\":\"\", \"username\":\"" + username.getText().toString() + "\", \"email\":\"" + email.getText().toString() + "\", \"password\":\"" + new_pass.getText().toString() + "\"}";

                // Execute the UserCreationTask
                new UserCreationTask(SignUp.this, userCreationCallback).execute(userData);



            }
        });

        signInTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, SignIn.class));
            }
        });
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void onUserCreationSuccess() {
        // Handle the case where user creation was successful
        // Save the email and password to SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email.getText().toString());
        editor.putString("password", new_pass.getText().toString());
        editor.apply();

        Intent intent = new Intent(this, select_your_favorite_topics.class);




        startActivity(intent);
    }


    @Override
    public void onUserCreationFailure(String errorMessage) {
        // Handle the case where user creation was not successful



        if (errorMessage.contains("Duplicate entry")) {
            // Handle the case where the username already exists
            username.setError("Username already exists. Please choose another one.");
        } else {
            // Handle other error cases
            username.setError("User creation failed. Please try again later.");
        }
    }


}