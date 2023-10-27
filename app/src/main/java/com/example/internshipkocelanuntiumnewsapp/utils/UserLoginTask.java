package com.example.internshipkocelanuntiumnewsapp.utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.internshipkocelanuntiumnewsapp.activity.NewsActivity;
import com.example.internshipkocelanuntiumnewsapp.activity.SignIn;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserLoginTask extends AsyncTask<String, Void, String> {
    private Context context;

    private SignIn signInActivity;
    private TextInputLayout emailTextInputLayout,passwordTextInputLayout;

    // Constructor to receive the context
    public UserLoginTask(SignIn activity, TextInputLayout emailTextInputLayout, TextInputLayout passwordTextInputLayout) {
        this.signInActivity = activity;
        this.emailTextInputLayout = emailTextInputLayout;
        this.passwordTextInputLayout = passwordTextInputLayout;
        this.context = activity;
    }


    @Override
    protected String doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();
        String email = params[0];
        String password = params[1];

        // Create a form body to send the data as form data
        RequestBody formBody = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url("https://jackal-modern-javelin.ngrok-free.app/login_users.php") // Replace with your API endpoint
                .post(formBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                return "Error: " + response.code();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("UserLoginTask", "Response: " + result);

        // Handle the API response here
        // You can parse the result JSON and perform actions based on the response
        try {
            JSONObject jsonResponse = new JSONObject(result);

            // Check if the "status" field in the JSON response is "success"
            String status = jsonResponse.optString("status", "");

            if (status.equals("success")) {
                Log.d("UserLoginTask", "Login successful");
                // Start the NewsActivity if login is successful
                Intent intent = new Intent(context, NewsActivity.class);
                context.startActivity(intent);
            } else {
                // Handle the case where login was not successful
                Log.d("UserLoginTask", "Login failed");

                String message = jsonResponse.optString("message", "");

                if (!message.isEmpty() && message.equals("Invalid username")) {
                    signInActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            emailTextInputLayout.setError("Invalid username");
                        }
                    });
                } else {
                    signInActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            passwordTextInputLayout.setError("Invalid  password");
                        }
                    });
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("UserLoginTask", "Error parsing JSON response");

            signInActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    emailTextInputLayout.setError("An error occurred");
                }
            });
        }
    }

}
