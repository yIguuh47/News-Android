package com.example.newsapp.rest

import com.example.newsapp.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("top-headlines")
    fun getAllNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsModel>

}