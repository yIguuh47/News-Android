package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.model.NewsModel
import com.squareup.picasso.Picasso


class NewsAdapter(val context: Context,
                  val itens: NewsModel):RecyclerView.Adapter<NewsViewHolder>() {

    var mainActivity = MainActivity()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cell_news, parent, false)
        val holder = NewsViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = itens.articles.get(position)
        holder.title.text = news.title
        holder.content.text = news.content
        Picasso.get().load(news.urlToImage).placeholder(R.drawable.progress_animation).into(holder.image)
        holder.itemView.setOnClickListener{
            mainActivity.gotoUrl(news.url)
        }
    }



    override fun getItemCount(): Int {
        return itens.articles.size
    }


}