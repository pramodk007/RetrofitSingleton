package com.androiddev.retrofitsingleton;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static RetrofitSingleton mInstance;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private Retrofit mRetrofit;

    //retrofitObject
    private RetrofitSingleton() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    //for creating instance/object for retrofit
    public static RetrofitSingleton getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitSingleton();
        }
        return mInstance;
    }
    //for interface
    public PostApi getJSONApi() {
        return mRetrofit.create(PostApi.class);
    }
}

