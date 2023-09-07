package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.internshipkocelanuntiumnewsapp.R;

public class Forgot_Password extends AppCompatActivity {

    EditText frgt_pswd_email;
    Button frgtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();

        frgtPassword = (Button) findViewById(R.id.next_forgot_btn);
        frgt_pswd_email = findViewById(R.id.forgot_password_EmailAddress);
        OnClickListeners();
        emailValidators();
    }

    public void emailValidators (){

        frgt_pswd_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                frgtPassword.setEnabled(false);


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



                if(charSequence.length() > 0){


                    frgt_pswd_email.setTextColor(getColor(R.color.gray_darker));
                    frgt_pswd_email.setBackgroundResource(R.drawable.rounded_corner_edit_text_typing);
                    frgt_pswd_email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope_typing_state,0,0,0);




                    if(Patterns.EMAIL_ADDRESS.matcher(charSequence).matches()){
                        //Email is valid

                        frgtPassword.setEnabled(true);
                    }else {
                        //Email is invalid
                        frgtPassword.setEnabled(false);
                        frgt_pswd_email.setError("Please enter a valid email address");
                    }





                }else {

                    frgt_pswd_email.setBackgroundResource(R.drawable.rounded_corner_view);
                    frgt_pswd_email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.envelope,0,0,0);



                }

            }

            @Override
            public void afterTextChanged(Editable editable) {



            }
        });

    }
    private void OnClickListeners(){
        frgtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Forgot_Password.this, create_new_password.class));
            }
        });
    }
}