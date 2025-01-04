package com.example.globewise.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import coil3.network.HttpException
import com.example.globewise.data.local.ArticleEntity
import com.example.globewise.data.local.NewsDatabase
import com.example.globewise.data.mapper.toEntity
import okio.IOException
import javax.inject.Inject

@Suppress("IMPLICIT_CAST_TO_ANY")
@OptIn(ExperimentalPagingApi::class)
class NewsRemoteMediator @Inject constructor(
    private val newsDatabase: NewsDatabase,
    private val newsApiService: NewsApiService
) : RemoteMediator<Int, ArticleEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ArticleEntity>
    ): MediatorResult  {
        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            val news = newsApiService.getTopHeadLine(
                country = "in",
                category = "General",
                pageSize = loadKey,
                pageCount = state.config.pageSize
            )
            newsDatabase.withTransaction {
                if (loadType == LoadType.REFRESH){
                    newsDatabase.newsDao().clearAll()
                }
                val newsEntities = news.articles.map { it.toEntity() }
                newsDatabase.newsDao().upsertAll(newsEntities)
            }
            MediatorResult.Success(
                endOfPaginationReached = news.articles.isEmpty()
            )
        }catch (e: HttpException){
            MediatorResult.Error(e)
        }catch (e: IOException){
            MediatorResult.Error(e)

        }
    }
}