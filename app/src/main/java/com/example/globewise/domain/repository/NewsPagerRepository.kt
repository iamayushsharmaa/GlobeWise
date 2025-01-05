package com.example.globewise.domain.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.globewise.data.local.ArticleEntity
import com.example.globewise.data.local.NewsDatabase
import com.example.globewise.data.remote.NewsApiService
import com.example.globewise.data.remote.NewsRemoteMediator
import javax.inject.Inject
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Singleton
class NewsPagerRepository @Inject constructor(
    private val newsApiService: NewsApiService,
    private val newsDatabase: NewsDatabase
) {
    fun getNewsPager(query: String?, country: String?, category: String?): Pager<Int, ArticleEntity> {
        return Pager(
            config = PagingConfig(
                pageSize = 50,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                newsDatabase.newsDao().pagingSource()   // Paging source from local database (Room)
            },
            remoteMediator = NewsRemoteMediator(
                query = query,
                country = country,
                category = category,
                newsDatabase = newsDatabase,
                newsApiService = newsApiService
            )
        )
    }
}
