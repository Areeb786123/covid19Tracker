package com.example.covid19_tracker.Model

class Response(
        var articles: List<Article>,
        val status: String,
        val totalResults: Int

)