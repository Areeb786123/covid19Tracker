package com.example.covid19_tracker.Retrofit

import com.example.covid19_tracker.Model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Reterofit_Service {
    @GET("v2/top-headlines?country=in&category=health")
    fun getNews(@Query("country") countryCode: String = "in",
                @Query("apiKey") apiKey: String = "21fc137255d647f2aa6515a0b284d6fd") : Call<Response>
}