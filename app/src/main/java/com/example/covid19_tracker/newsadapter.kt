package com.example.covid19_tracker

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class newsadapter(private val listener: NewsItemClicked):RecyclerView.Adapter<ViewHolder>(){

    private val items: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val View = LayoutInflater.from(parent.context).inflate(R.layout.newslist,parent,false)
        return  ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem =items[position]
        holder.titleView.text= currentitem.title
        holder.author.text = currentitem.author
        Glide.with(holder.itemView.context).load(currentitem.imageUrl).into(holder.image)

    }

    fun upadtedNews(updatedNews: ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return  items.size
    }


}

class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val titleView :TextView = itemView.findViewById(R.id.title)
    val image: ImageView =itemView.findViewById(R.id.image)
    val author: TextView = itemView.findViewById(R.id.author)

}

interface NewsItemClicked{
    fun onItemClicked(item: News)
}