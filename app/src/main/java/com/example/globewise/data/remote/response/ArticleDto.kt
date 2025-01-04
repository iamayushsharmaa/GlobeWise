package com.example.globewise.data.remote.response

data class ArticleDto(
    val author: String?,
    val content: String,
    val description: String?,
    val publishedAt: String,
    val source: SourceDto,
    val title: String,
    val url: String,
    val urlToImage: String?
)