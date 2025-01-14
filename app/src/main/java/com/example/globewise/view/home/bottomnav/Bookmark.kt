package com.example.globewise.view.home.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.globewise.ui.theme.poppinsFontFamily
import com.example.globewise.view.home.card.NewsCard
import com.example.globewise.viewmodel.BookmarkViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Bookmark(
    bookmarkViewModel: BookmarkViewModel = hiltViewModel()
) {

    val articles by bookmarkViewModel.articles.collectAsState()

    Scaffold (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bookmark",
                    fontFamily = poppinsFontFamily,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                items(articles) { article ->
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
            }

        }
    }
}