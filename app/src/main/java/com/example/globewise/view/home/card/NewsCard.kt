package com.example.globewise.view.home.card

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.globewise.R
import com.example.globewise.domain.Article
import com.example.globewise.domain.Source
import com.example.globewise.ui.theme.poppinsFontFamily

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClickSave: (Article) -> Unit = {},
    onClickDelete: (Article) -> Unit = {}
) {
    var isBookmarked by remember { mutableStateOf(false) }

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
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
                    .size(145.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 3.dp)
            ) {
                Text( // category name
                    text = article.author ?: "Unknown",
                    fontFamily = poppinsFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray
                )
                Text(
                    text = article.title,
                    fontFamily = poppinsFontFamily,
                    fontSize = 20.sp,
                    maxLines = 2,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(35.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = article.publishedAt,
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = {
                            if (isBookmarked) {
                                onClickDelete(article)
                            }else{
                                onClickSave(article)
                            }
                            isBookmarked = !isBookmarked
                        },
                        modifier = Modifier.padding(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = if (isBookmarked) R.drawable.icon_savefilled else R.drawable.icon_saveblank),
                            contentDescription = "bookmark icon",
                            modifier = Modifier.size(23.dp)
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