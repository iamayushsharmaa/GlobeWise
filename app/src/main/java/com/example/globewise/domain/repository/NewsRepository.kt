package com.example.globewise.domain.repository

import com.example.globewise.data.remote.resource.Resource
import com.example.globewise.data.remote.response.NewsResult
import kotlinx.coroutines.flow.Flow


interface NewsRepositoryss {
    suspend fun getEverything(query: String): Flow<Resource<NewsResult>>
    suspend fun getTopHeadlines(country: String, category: String): Flow<Resource<NewsResult>>
}
