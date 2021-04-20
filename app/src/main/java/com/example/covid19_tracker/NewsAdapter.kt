package com.example.covid19_tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19_tracker.Model.Article
import com.squareup.picasso.Picasso

class NewsAdapter (private val newsList :List<Article>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var urlToImage: ImageView

        init {
            title = view.findViewById(R.id.title)
            urlToImage = view.findViewById(R.id.urlToImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newslist, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = newsList[position]
        holder.title.text = current.title
        Picasso.get().load(newsList[position].urlToImage).into(holder.urlToImage)

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}

