package com.example.internshipkocelanuntiumnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    Button signIn,googleSignIn,faceBookSignIn;
    TextView forgotPassword;
    LinearLayout signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);







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