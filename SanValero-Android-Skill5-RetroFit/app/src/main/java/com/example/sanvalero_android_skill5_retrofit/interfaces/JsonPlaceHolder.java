package com.example.sanvalero_android_skill5_retrofit.interfaces;

import com.example.sanvalero_android_skill5_retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Post>> getPosts();

}
