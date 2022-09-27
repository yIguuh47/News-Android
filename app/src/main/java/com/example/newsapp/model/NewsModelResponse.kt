package com.example.newsapp.model

import retrofit2.Response

class NewsModelResponse {

    var news = NewsModel()

    fun getList(newsResponse: Response<NewsModel>) {
        news = newsResponse.body()!!
    }



}