package com.androiddev.retrofitsingleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RetrofitSingleton retrofitSingleton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPost();
    }

    private void getPost() {

    retrofitSingleton.getInstance().getJSONApi().getPostWithID(4).enqueue(new Callback<PostModel>() {
        @Override
        public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                PostModel postModel = response.body();
                Toast.makeText(MainActivity.this, postModel.getTitle(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(Call<PostModel> call, Throwable t) {
            Toast.makeText(MainActivity.this, "error on fetching the data", Toast.LENGTH_SHORT).show();
        }
    });
    }
}