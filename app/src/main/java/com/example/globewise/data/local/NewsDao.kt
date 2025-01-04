package com.example.globewise.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface NewsDao {

    @Insert
    suspend fun insertArticles(articles: ArticleEntity)

    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Delete
    suspend fun deleteArticle(article: ArticleEntity)

    @Upsert
    suspend fun upsertAll(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles")
    fun pagingSource(query: String): PagingSource<Int, ArticleEntity>

    @Query("DELETE FROM articles")
    suspend fun clearAll()
}