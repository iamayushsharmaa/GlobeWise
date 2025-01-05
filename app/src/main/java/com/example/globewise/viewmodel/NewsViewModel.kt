package com.example.globewise.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.globewise.data.local.ArticleEntity
import com.example.globewise.data.mapper.toArticle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    pager: Pager<Int, ArticleEntity>   // Pager injected from the DI module
) : ViewModel() {

    val newsPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toArticle() }   // Map from ArticleEntity to Article
        }
        .cachedIn(viewModelScope)  // Cache the data in the ViewModel scope to survive configuration changes
}