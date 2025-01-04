package com.example.globewise.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globewise.data.remote.resource.Resource
import com.example.globewise.data.remote.resource.UiState
import com.example.globewise.data.remote.response.NewsResult
import com.example.globewise.domain.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _everythingState = MutableStateFlow(UiState<NewsResult>(isLoading = true))
    val everythingState: StateFlow<UiState<NewsResult>> = _everythingState

    private val _topHeadlinesState = MutableStateFlow(UiState<NewsResult>(isLoading = true))
    val topHeadlinesState: StateFlow<UiState<NewsResult>> = _topHeadlinesState

    fun fetchEverything(query: String) {
        viewModelScope.launch {
            newsRepository.getEverything(query).collect { resource ->
                _everythingState.value = when (resource) {
                    is Resource.Loading -> UiState(isLoading = true)
                    is Resource.Success -> UiState(data = resource.data)
                    is Resource.Error -> UiState(errorMessage = resource.message)
                }
            }
        }
    }

    fun fetchTopHeadlines(country: String, category: String) {
        viewModelScope.launch {
            newsRepository.getTopHeadlines(country, category).collect { resource ->
                _topHeadlinesState.value = when (resource) {
                    is Resource.Loading -> UiState(isLoading = true)
                    is Resource.Success -> UiState(data = resource.data)
                    is Resource.Error -> UiState(errorMessage = resource.message)
                }
            }
        }
    }
}
