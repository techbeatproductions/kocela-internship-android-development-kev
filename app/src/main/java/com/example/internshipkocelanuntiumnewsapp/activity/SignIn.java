package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.internshipkocelanuntiumnewsapp.R;

public class SignIn extends AppCompatActivity {

    Button signIn,googleSignIn,faceBookSignIn;
    TextView forgotPassword,or;
    EditText email,password;
    LinearLayout signUp,signUp_redirect;
    ImageView eye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email = findViewById(R.id.sign_in_editTextTextEmailAddress);
        password = findViewById(R.id.sign_in_editTextTextPassword);
        eye = findViewById(R.id.eye_show_password_sign_in);

        googleSignIn = findViewById(R.id.signinwithgooglebutton);
        faceBookSignIn = findViewById(R.id.signinwithfacebookbutton);
        or = findViewById(R.id.or_txt_view);
        signUp_redirect = findViewById(R.id.sign_in_sign_up_redirect);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() > 0){
                googleSignIn.setVisibility(View.INVISIBLE);
                faceBookSignIn.setVisibility(View.INVISIBLE);
                signUp_redirect.setVisibility(View.INVISIBLE);
                or.setVisibility(View.INVISIBLE);

                email.setTextColor(getColor(R.color.gray_darker));
                email.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope_typing_state,0,0,0);

                password.setTextColor(getColor(R.color.gray_darker));
                password.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock_typing_state,0,0,0);
                eye.setVisibility(View.VISIBLE);





                }else {
                    googleSignIn.setVisibility(View.VISIBLE);
                    faceBookSignIn.setVisibility(View.VISIBLE);
                    signUp_redirect.setVisibility(View.VISIBLE);
                    or.setVisibility(View.VISIBLE);

                    email.setBackgroundResource(R.drawable.rounded_corner_view);
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope,0,0,0);
                    password.setBackgroundResource(R.drawable.rounded_corner_view);
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock,0,0,0);
                    eye.setVisibility(View.INVISIBLE);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() > 0){
                    googleSignIn.setVisibility(View.INVISIBLE);
                    faceBookSignIn.setVisibility(View.INVISIBLE);
                    signUp_redirect.setVisibility(View.INVISIBLE);
                    or.setVisibility(View.INVISIBLE);

                    email.setTextColor(getColor(R.color.gray_darker));
                    email.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope_typing_state,0,0,0);

                    password.setTextColor(getColor(R.color.gray_darker));
                    password.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock_typing_state,0,0,0);
                    eye.setVisibility(View.VISIBLE);





                }else {
                    googleSignIn.setVisibility(View.VISIBLE);
                    faceBookSignIn.setVisibility(View.VISIBLE);
                    signUp_redirect.setVisibility(View.VISIBLE);
                    or.setVisibility(View.VISIBLE);

                    email.setBackgroundResource(R.drawable.rounded_corner_view);
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope,0,0,0);
                    password.setBackgroundResource(R.drawable.rounded_corner_view);
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock,0,0,0);
                    eye.setVisibility(View.INVISIBLE);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });










    }





    public void OnClickListeners(View view){
        if(view.getId() == R.id.signinbutton){
           startActivity(new Intent(SignIn.this, select_your_favorite_topics.class));

        } else if (view.getId() == R.id.signinwithgooglebutton) {
            startActivity(new Intent(SignIn.this, select_your_favorite_topics.class));

        } else if (view.getId() == R.id.signinwithfacebookbutton ) {
            startActivity(new Intent(SignIn.this, select_your_favorite_topics.class));

        } else if (view.getId() == R.id.forgot_password_clickable_txt) {
            startActivity(new Intent(SignIn.this, Forgot_Password.class));

        } else if (view.getId() == R.id.sign_in_sign_up_redirect) {
            startActivity(new Intent(SignIn.this, SignUp.class));


        }


    }

}