package com.example.globewise.data.local

import com.example.globewise.data.mapper.toArticle
import com.example.globewise.data.mapper.toEntity
import com.example.globewise.domain.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val database: NewsDatabase
) {

    suspend fun saveArticle(article: Article) {
        val articleEntity = article.toEntity()
        database.newsDao().insertArticles(articleEntity)
    }

    fun getAllSavedArticles(): Flow<List<Article>> {
        return database.newsDao().getAllArticles().map { articleEntities ->
            articleEntities.map { it.toArticle() }
        }
    }

    suspend fun deleteArticle(article: Article) {
        val articleEntity = article.toEntity()
        database.newsDao().deleteArticle(articleEntity)
    }
}