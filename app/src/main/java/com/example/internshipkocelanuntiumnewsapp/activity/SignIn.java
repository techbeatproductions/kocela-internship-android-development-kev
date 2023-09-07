package com.example.internshipkocelanuntiumnewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.internshipkocelanuntiumnewsapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignIn extends AppCompatActivity {

    private static final String TAG = "SignInActivity"; // Tag for logging

    Button signIn, googleSignIn, faceBookSignIn;
    TextView forgotPassword, or, errorTvText;
    TextInputEditText email, password;
    TextInputLayout emailTextInputLayout, passwordTextInputLayout;
    LinearLayout signUp, signUp_redirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide(); // Hiding action bar

        emailTextInputLayout = findViewById(R.id.sign_in_editText_container);
        passwordTextInputLayout = findViewById(R.id.sign_in_password_container);
        email = findViewById(R.id.sign_in_editTextTextEmailAddress);
        password = findViewById(R.id.sign_in_editTextTextPassword);

        // Prevent keyboard from showing up immediately
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        googleSignIn = findViewById(R.id.signinwithgooglebutton);
        faceBookSignIn = findViewById(R.id.signinwithfacebookbutton);
        signIn = findViewById(R.id.signinbutton);
        or = findViewById(R.id.or_txt_view);
        signUp_redirect = findViewById(R.id.sign_in_sign_up_redirect);
        emailTextInputLayout.setHintTextColor(ColorStateList.valueOf(getColor(R.color.gray_primary)));
        passwordTextInputLayout.setHintTextColor(ColorStateList.valueOf(getColor(R.color.gray_primary)));
        email.setBackground(getDrawable(R.drawable.rounded_corner_view));

        // Initially set the buttons unclickable
        disableButtons();

        emailValidators();
        passwordValidators();
    }

    public void OnClickListeners(View view) {
        if (view.getId() == R.id.signinbutton) {
            // Validate email and password here before navigating to the next activity
            String userEmail = email.getText().toString().trim();
            String userPassword = password.getText().toString().trim();

            if (isValidEmail(userEmail) && !TextUtils.isEmpty(userPassword)) {
                Log.d(TAG, "Sign-in successful");
                startActivity(new Intent(SignIn.this, select_your_favorite_topics.class));
            } else {
                // Handle invalid email or password
                Log.d(TAG, "Sign-in failed");
                errorTvText.setVisibility(View.VISIBLE);
                errorTvText.setText("Invalid email or password");
            }
        } else if (view.getId() == R.id.signinwithgooglebutton) {
            Log.d(TAG, "Sign in with Google button clicked");
            startActivity(new Intent(SignIn.this, select_your_favorite_topics.class));
        } else if (view.getId() == R.id.signinwithfacebookbutton) {
            Log.d(TAG, "Sign in with Facebook button clicked");
            startActivity(new Intent(SignIn.this, select_your_favorite_topics.class));
        } else if (view.getId() == R.id.forgot_password_clickable_txt) {
            Log.d(TAG, "Forgot password clicked");
            startActivity(new Intent(SignIn.this, Forgot_Password.class));
        } else if (view.getId() == R.id.sign_in_sign_up_redirect) {
            Log.d(TAG, "Sign-up redirect clicked");
            startActivity(new Intent(SignIn.this, Onboarding.class));
        }
    }

    public void emailValidators() {
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Check if email is empty or invalid
                String emailText = charSequence.toString().trim();
                boolean isValidEmail = isValidEmail(emailText);

                if (!TextUtils.isEmpty(emailText) && isValidEmail) {
                    // Email is not empty and valid, remove error
                    emailTextInputLayout.setError(null);
                    emailTextInputLayout.setHintTextColor(ColorStateList.valueOf(getColor(R.color.gray_primary)));
                    emailTextInputLayout.setErrorTextColor(ColorStateList.valueOf(getColor(R.color.gray_primary)));
                    email.setTextColor(getColor(R.color.gray_primary));
                    email.setBackground(getDrawable(R.drawable.rounded_corner_edit_text_typing));

                    enableButtons();
                } else {
                    // Email is empty or invalid, set error
                    if (TextUtils.isEmpty(emailText)) {
                        emailTextInputLayout.setError(null); // Clear error when text is empty
                    } else {
                        emailTextInputLayout.setError("Please enter a valid email address");
                        emailTextInputLayout.setHintTextColor(ColorStateList.valueOf(getColor(R.color.gray_primary)));
                        emailTextInputLayout.setErrorTextColor(ColorStateList.valueOf(getColor(R.color.gray_primary)));
                        email.setTextColor(getColor(R.color.gray_primary));
                        email.setBackground(getDrawable(R.drawable.rounded_corner_edit_text_typing));
                    }

                    disableButtons();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void passwordValidators() {
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password.setBackground(getDrawable(R.drawable.rounded_corner_view));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Check if password is empty
                String passwordText = charSequence.toString().trim();


                if (!TextUtils.isEmpty(passwordText)) {
                    // Password is not empty, remove error
                    passwordTextInputLayout.setError(null);
                    passwordTextInputLayout.setHintTextColor(ColorStateList.valueOf(getColor(R.color.gray_primary)));

                    passwordTextInputLayout.setErrorTextColor(ColorStateList.valueOf(getResources().getColor(R.color.gray_primary)));
                    password.setBackground(getDrawable(R.drawable.rounded_corner_edit_text_typing));
                    enableButtons();
                } else {
                    // Password is empty, set error
                    passwordTextInputLayout.setError("Please enter a password");
                    passwordTextInputLayout.setHintTextColor(ColorStateList.valueOf(getColor(R.color.gray_primary)));

                    passwordTextInputLayout.setErrorTextColor(ColorStateList.valueOf(getResources().getColor(R.color.gray_primary)));
                    password.setBackground(getDrawable(R.drawable.rounded_corner_edit_text_typing));
                    disableButtons();
                }
                googleSignIn.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void enableButtons() {
        signIn.setEnabled(true);
        googleSignIn.setEnabled(true);
        faceBookSignIn.setEnabled(true);

    }

    private void disableButtons() {
        signIn.setEnabled(false);

    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        // Implement your password validation logic here
        // Example: return password.length() >= 6;
        return !TextUtils.isEmpty(password);
    }
}
