package com.example.globewise.view.home.bottomnav

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.globewise.ui.theme.poppinsFontFamily
import com.example.globewise.view.home.card.NewsCard
import com.example.globewise.view.home.card.SlideImageCard
import com.example.globewise.viewmodel.NewsViewModel

@Composable
fun Home(
    newsViewModel : NewsViewModel = hiltViewModel(),
) {
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
                    text = "Home",
                    fontFamily = poppinsFontFamily,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            if (articles.loadState.refresh is LoadState.Loading) {
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
            } else {
                SlideImageCard(
                    modifier = Modifier
                        .padding(8.dp)
                )

                Text(
                    text = "News",
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp)
                )

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
                                article = article
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
    }
}



//@Preview
//@Composable
//private fun HomePrev() {
//    Home()
//}
