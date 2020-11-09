package com.example.covid19_tracker

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import java.util.Calendar.getInstance

class NewsActivity : AppCompatActivity(), NewsItemClicked {
    private lateinit var  mAdapter: newsadapter

    private lateinit var recyclerView1:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        recyclerView1 = findViewById(R.id.recyclerView1)

        recyclerView1.layoutManager = LinearLayoutManager(this)
        fetchdata()
        mAdapter = newsadapter(this)
        recyclerView1.adapter = mAdapter
    }
    private  fun fetchdata() {

        val url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=9af757f8a2b4449fa1e8f85c82deeaa2"
        val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                {
                    val newsJsonArray = it.getJSONArray("articles")
                    val newsArray = ArrayList<News>()
                    for(i in 0 until newsJsonArray.length()){
                        val  newsJSONObject =newsJsonArray.getJSONObject(i)
                        val news =News(
                                newsJSONObject.getString("title"),
                                newsJSONObject.getString("author"),
                                newsJSONObject.getString("url"),
                                newsJSONObject.getString("urlToImage")

                        )

                        newsArray.add(news)

                    }

                    mAdapter.upadtedNews(newsArray)


                },
                {

                }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }

    override fun onItemClicked(item: News) {

        val builder =  CustomTabsIntent.Builder();
        val  customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(item.url));
    }





}