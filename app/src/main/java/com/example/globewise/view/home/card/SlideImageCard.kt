package com.example.globewise.view.home.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globewise.R
import com.example.globewise.ui.theme.poppinsFontFamily

@Composable
fun SlideImageCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(22.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.new_image_template),
                contentDescription = "slide image for home"
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, bottom = 16.dp, end = 16.dp)
                    .align(Alignment.BottomStart),
            ){
                Text(
                    text = "HeadLine for new in Slide view",
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 35.sp
                )
                Text(
                    text = "3 hours ago",
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun SlideImagePrev() {
    SlideImageCard()
}