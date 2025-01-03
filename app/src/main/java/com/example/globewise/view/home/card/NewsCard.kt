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
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globewise.R
import com.example.globewise.ui.theme.poppinsFontFamily

@Composable
fun NewsCard(
    modifier: Modifier = Modifier
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
            Image(
                modifier = Modifier
                    .size(160.dp),
                painter = painterResource(id = R.drawable.new_image_template),
                contentDescription = "new image"
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(12.dp)
            ) {
                Text( // category name
                    text = "Sports",
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "New title top headlines?",
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
                        text = "12:00 PM",
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(
                        onClick = {},
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