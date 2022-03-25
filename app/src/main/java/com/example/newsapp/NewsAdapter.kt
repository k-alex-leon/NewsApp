package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NewsAdapter(newsList: MutableList<News>, var context: Context):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var arrayNewsList = newsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_news, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        val news : News = arrayNewsList[position]
        holder.title.text = news.getTitleNew()
        Picasso.get().load(news.getImageNew()).into(holder.image)
    }

    override fun getItemCount(): Int {
        return arrayNewsList.size
    }

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.imgVNews)
        var title : TextView = itemView.findViewById(R.id.txtVTitleNews)
    }
}