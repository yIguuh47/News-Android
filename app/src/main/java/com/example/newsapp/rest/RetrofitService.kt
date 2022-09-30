package com.example.newsapp.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService private constructor(){

    companion object {

        private lateinit var  retrofit: Retrofit
        private const val  BASE_URL = "https://newsapi.org/v2/"

        private fun getRetrofitInstance(): Retrofit {
            val httpClient = OkHttpClient.Builder()
            if (!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun createService(): RetrofitInterface {
            return getRetrofitInstance().create(RetrofitInterface::class.java)
        }

    }

}