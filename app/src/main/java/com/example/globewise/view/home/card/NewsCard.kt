package com.example.globewise.view.home.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.globewise.R
import com.example.globewise.domain.Article
import com.example.globewise.domain.Source
import com.example.globewise.ui.theme.poppinsFontFamily

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    article: Article
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = "image of news",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(12.dp)
            ) {
                Text( // category name
                    text = article.author ?: "Unknown",
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = article.title,
                    fontFamily = poppinsFontFamily,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                ) {
                    Text(
                        text = article.publishedAt,
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxHeight()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_saveblank),
                            contentDescription = "bookmark icon"
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsCard() {
    NewsCard(
        article = Article(
            author = "John Doe",
            content = "This is a detailed article about Jetpack Compose and its advantages...",
            description = "Learn how Jetpack Compose can help you build beautiful UIs with less code.",
            publishedAt = "2025-01-05T12:34:00Z",
            source = Source(id = "1", name = "Tech News"),
            title = "Jetpack Compose: A New Era of Android UI",
            url = "https://www.example.com",
            urlToImage = "https://www.example.com/image.jpg"
        )
    )
}