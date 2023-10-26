package com.example.internshipkocelanuntiumnewsapp.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.internshipkocelanuntiumnewsapp.activity.select_your_favorite_topics;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserCreationTask extends AsyncTask<String, Void, String> {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private Context context;

    public interface UserCreationCallback {
        void onUserCreationSuccess();
        void onUserCreationFailure(String errorMessage);
    }

    private UserCreationCallback callback;

    // Constructor to receive the context
    public UserCreationTask(Context context, UserCreationCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected String doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();
        String json = params[0]; // JSON data for user creation

        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url("https://jackal-modern-javelin.ngrok-free.app/create_users.php") // Replace with your API endpoint
                .post(body)
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
        Log.d("UserCreationTask", "Response: " + result);

        try {
            JSONObject jsonResponse = new JSONObject(result);

            // Check if the "success" field in the JSON response is true
            boolean success = jsonResponse.optBoolean("success", false);

            if (success) {
                Log.d("UserCreationTask", "User created successfully");

                // Extract the user ID from the JSON response
                String userId = jsonResponse.optString("user_id", "");

                if (!userId.isEmpty()) {
                    // Save the user ID to SharedPreferences
                    SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userID", userId);
                    editor.apply();
                }

                callback.onUserCreationSuccess();
            } else {
                // User creation was not successful
                String errorMessage = jsonResponse.optString("error", "Unknown error");

                if (errorMessage.equalsIgnoreCase("Duplicate entry")) {
                    // Handle the case where the username already exists
                    callback.onUserCreationFailure("Username already exists. Please choose another one.");
                } else {
                    // Handle other error cases
                    Log.d("UserCreationTask", "User creation failed with error: " + errorMessage);
                    callback.onUserCreationFailure("User creation failed with error: " + errorMessage);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("UserCreationTask", "Error parsing JSON response");
            callback.onUserCreationFailure("Error parsing JSON response");
        }
    }

}
