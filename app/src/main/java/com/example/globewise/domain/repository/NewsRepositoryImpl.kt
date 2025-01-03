package com.example.globewise.domain.repository

import com.example.globewise.data.remote.NewsApiService
import com.example.globewise.data.remote.NewsApiService.Companion.API_KEY
import com.example.globewise.data.remote.resource.Resource
import com.example.globewise.data.remote.response.NewsResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : NewsRepository {
    override suspend fun getEverything(query: String): Flow<Resource<NewsResult>> = flow{
        try {
            emit(Resource.Loading)
            val result = newsApiService.getEverything(query, API_KEY)
            emit(Resource.Success(result))
        }catch (e: Exception) {
            emit(Resource.Error("Failed to fetch news: ${e.localizedMessage}", e))
        }
    }

    override suspend fun getTopHeadlines(country: String, category: String): Flow<Resource<NewsResult>> = flow {
        try {
            emit(Resource.Loading)
            val result = newsApiService.getTopHeadLine(country, category, 100, API_KEY)
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error("Failed to fetch top headlines: ${e.localizedMessage}", e))
        }
    }
}