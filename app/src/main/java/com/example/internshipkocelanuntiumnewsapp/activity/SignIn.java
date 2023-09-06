package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internshipkocelanuntiumnewsapp.R;

public class SignIn extends AppCompatActivity {

    Button signIn,googleSignIn,faceBookSignIn;
    TextView forgotPassword,or, errorTvText;
    EditText email,password;
    LinearLayout signUp,signUp_redirect;
    ImageView eye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide(); //Hiding action bar

        email = findViewById(R.id.sign_in_editTextTextEmailAddress);
        password = findViewById(R.id.sign_in_editTextTextPassword);




        googleSignIn = findViewById(R.id.signinwithgooglebutton);
        faceBookSignIn = findViewById(R.id.signinwithfacebookbutton);
        signIn = findViewById(R.id.signinbutton);

        or = findViewById(R.id.or_txt_view);
        signUp_redirect = findViewById(R.id.sign_in_sign_up_redirect);





        emailValidators();


    }



    public void OnClickListeners(View view){
        if(view.getId() == R.id.signinbutton){
            emailValidators();
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

    public void emailValidators (){

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                signIn.setEnabled(false);


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


                    if(Patterns.EMAIL_ADDRESS.matcher(charSequence).matches()){
                        //Email is valid

                        signIn.setEnabled(true);
                    }else {
                        //Email is invalid
                        signIn.setEnabled(false);
                        email.setError("Please enter a valid email address");
                    }





                }else {
                    googleSignIn.setVisibility(View.VISIBLE);
                    faceBookSignIn.setVisibility(View.VISIBLE);
                    signUp_redirect.setVisibility(View.VISIBLE);
                    or.setVisibility(View.VISIBLE);

                    email.setBackgroundResource(R.drawable.rounded_corner_view);
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope,0,0,0);
                    password.setBackgroundResource(R.drawable.rounded_corner_view);
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock,0,0,0);


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {



            }
        });

    }

    public void passwordValidators (){

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                signIn.setEnabled(false);


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


                    if(Patterns.EMAIL_ADDRESS.matcher(charSequence).matches()){
                        //Email is valid
                        signIn.setEnabled(true);
                    }else {
                        //Email is invalid
                        signIn.setEnabled(false);


                    }





                }else {
                    googleSignIn.setVisibility(View.VISIBLE);
                    faceBookSignIn.setVisibility(View.VISIBLE);
                    signUp_redirect.setVisibility(View.VISIBLE);
                    or.setVisibility(View.VISIBLE);

                    email.setBackgroundResource(R.drawable.rounded_corner_view);
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope,0,0,0);
                    password.setBackgroundResource(R.drawable.rounded_corner_view);
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.padlock,0,0,0);


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {



            }
        });

    }

}