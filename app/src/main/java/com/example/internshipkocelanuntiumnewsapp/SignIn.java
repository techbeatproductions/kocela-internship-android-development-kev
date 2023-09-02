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

public class SignIn extends AppCompatActivity {

    Button signIn,googleSignIn,faceBookSignIn;
    TextView forgotPassword,or;
    EditText email;
    LinearLayout signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email = findViewById(R.id.sign_in_editTextTextEmailAddress);
        googleSignIn = findViewById(R.id.signinwithgooglebutton);
        faceBookSignIn = findViewById(R.id.signinwithfacebookbutton);
        or = findViewById(R.id.or_txt_view);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() > 0){
                googleSignIn.setVisibility(View.INVISIBLE);
                faceBookSignIn.setVisibility(View.INVISIBLE);
                }else {
                    googleSignIn.setVisibility(View.VISIBLE);
                    faceBookSignIn.setVisibility(View.VISIBLE);
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