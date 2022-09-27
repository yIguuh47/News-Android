package com.example.newsapp

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.model.NewsModel
import com.example.newsapp.model.NewsModelResponse
import com.example.newsapp.rest.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    var modelNews = NewsModelResponse()
    var apiKey = "9d25345ac4ad4cbfb7ca96b6a1466722"
    var language = "PT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getNews()
    }

    fun getNews() {
        val service = RetrofitService.createService()
        val call : Call<NewsModel> = service.getAllNews(language, apiKey)


        call.enqueue(object : Callback<NewsModel>  {
            override fun onResponse(call: Call<NewsModel>,
                                    response: Response<NewsModel> ) {
                if (response?.code() == 200) {
                    val responseNews = response
                    modelNews.getList(newsResponse = responseNews)
                    configRecycler()
                } else {
                    print("Error ${response.code()}")
                }
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                print(t.message)

            }
        })
        return
    }

    fun configRecycler() {
        val adapter = NewsAdapter(applicationContext, modelNews.news)
        binding.rvNoticias.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvNoticias.itemAnimator = DefaultItemAnimator()
        binding.rvNoticias.adapter = adapter
    }

    fun gotoUrl(url: String){
        val uri = Uri.parse("http://www.google.com")
    }
}