package com.androiddev.retrofitsingleton;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostApi {
    @GET("/posts/{id}")
    public Call<PostModel> getPostWithID(@Path("id") int id);
}
