package com.example.globewise.data.remote.response

data class NewsResult(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)