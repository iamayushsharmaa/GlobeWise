package com.example.globewise.view.home.tabs


import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.globewise.view.home.card.NewsCard
import com.example.globewise.viewmodel.BookmarkViewModel
import com.example.globewise.viewmodel.NewsViewModel


@Composable
fun ForYou(
    newsViewModel: NewsViewModel = hiltViewModel(),
    bookmarkViewModel: BookmarkViewModel = hiltViewModel()
) {
    var category by remember { mutableStateOf("general") }
    val context = LocalContext.current
    val articles = newsViewModel.newsPagingFlow.collectAsLazyPagingItems()

    LaunchedEffect (key1 = articles.loadState){
        if (articles.loadState.refresh is LoadState.Error){
            Toast.makeText(
                context,
                "Error: " + (articles.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            items(articles.itemSnapshotList) { article ->
                if (article != null) {
                    NewsCard(
                        modifier = Modifier
                            .padding(8.dp),
                        article = article,
                        onClickSave = {
                            bookmarkViewModel.saveArticle(article)
                        },
                        onClickDelete = {
                            bookmarkViewModel.deleteArticle(article)
                        }
                    )
                }
            }
            item {
                if (articles.loadState.append is LoadState.Loading) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }

                }
            }
        }
    }
}