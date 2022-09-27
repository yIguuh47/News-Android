package com.example.newsapp.model

import com.google.gson.annotations.SerializedName

class NewsModel {
    @SerializedName("articles")
    val articles: List<Articles> = listOf()
}

class Articles {
    @SerializedName("title")
    val title: String = ""

    @SerializedName("url")
    val url: String = ""

    @SerializedName("urlToImage")
    val urlToImage: String = ""

    @SerializedName("content")
    val content: String = ""
}
