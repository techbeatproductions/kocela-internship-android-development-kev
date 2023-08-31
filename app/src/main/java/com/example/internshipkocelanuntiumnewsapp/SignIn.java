package com.example.internshipkocelanuntiumnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    Button signIn,googleSignIn,faceBookSignIn;
    TextView forgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signIn= (Button) findViewById(R.id.signinbutton);

        googleSignIn=(Button) findViewById(R.id.signinwithgooglebutton);
        faceBookSignIn=(Button) findViewById(R.id.signinwithfacebookbutton);
        forgotPassword=(TextView) findViewById(R.id.forgot_password_clickable_txt) ;




        OnClickListeners();

    }

    private void OnClickListeners(){
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, select_your_favorite_topics.class));
            }


        });

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, select_your_favorite_topics.class));
            }


        });

        faceBookSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, select_your_favorite_topics.class));
            }


        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, Forgot_Password.class));
            }
        });


    }

}