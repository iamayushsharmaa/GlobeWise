package com.example.globewise.data.remote

import com.example.globewise.data.remote.response.NewsResult
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsResult

    @GET("/v2/top-headlines")
    suspend fun getTopHeadLine(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int = 100,
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsResult

    companion object{
        const val BASE_URL = "https://newsapi.org"
        const val API_KEY = "00700dcc7c6d44ae89a6891b3ef3367f"
    }
}
