package com.emon.retrofitsimplegetexample.retrofit;

import com.emon.retrofitsimplegetexample.model.Model;
import com.emon.retrofitsimplegetexample.model.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolder {
    @GET("posts")
    Call<List<Post>> getPost();

    @GET ("photos")
    Call<List<Model>> getModel(@QueryMap Map<String,String> peramiters);

    @GET("photos")
    Call<List<Model>> getModel(
            @Query("albumId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );
}
