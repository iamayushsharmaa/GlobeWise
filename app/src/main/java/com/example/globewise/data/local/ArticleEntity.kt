package com.example.globewise.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceEntity?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)

data class SourceEntity(
    val id: String?,
    val name: String?
)