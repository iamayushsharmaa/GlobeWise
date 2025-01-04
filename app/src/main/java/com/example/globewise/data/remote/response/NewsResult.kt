package com.example.globewise.data.remote.response

data class NewsResult(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)