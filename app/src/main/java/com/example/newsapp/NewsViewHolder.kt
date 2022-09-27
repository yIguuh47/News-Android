package com.example.newsapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView!!.findViewById(R.id.tv_title)
    val content: TextView = itemView!!.findViewById(R.id.tv_content)
    var image: ImageView = itemView!!.findViewById(R.id.iv_new)
}