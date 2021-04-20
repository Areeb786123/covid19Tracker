package com.example.covid19_tracker.Retrofit

object Common {

    private val BASE_URL ="https://newsapi.org/"

    val reterofitService:Reterofit_Service
        get() = RetrofitClient.getClient(BASE_URL).create(Reterofit_Service::class.java)
}