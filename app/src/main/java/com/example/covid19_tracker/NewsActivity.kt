package com.example.covid19_tracker

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.covid19_tracker.Model.Response
import com.example.covid19_tracker.Retrofit.Common
import com.example.covid19_tracker.Retrofit.Reterofit_Service
import kotlinx.android.synthetic.main.activity_news.*
import retrofit2.Call
import retrofit2.Callback
import java.util.Calendar.getInstance

class NewsActivity : AppCompatActivity(){
    lateinit var mAdapter: NewsAdapter
    lateinit var mService: Reterofit_Service
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)



        mService = Common.reterofitService

        news_recycler.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        news_recycler.layoutManager = layoutManager

        getAllNews()


    }

    private fun getAllNews() {
        mService.getNews().enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val newsList = response.body()!!.articles
                mAdapter = NewsAdapter(newsList)
                news_recycler.adapter = mAdapter

            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

}