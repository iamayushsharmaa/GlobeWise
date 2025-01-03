package com.example.globewise.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globewise.ui.theme.poppinsFontFamily
import com.example.globewise.view.home.card.NewsCard
import com.example.globewise.view.home.card.SlideImageCard

@Composable
fun Home() {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Home",
                fontFamily = poppinsFontFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        SlideImageCard(
            modifier = Modifier
                .padding(8.dp)
        )

        Text(
            text = "News",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp)
        )
        NewsCard(
            modifier = Modifier
                .padding(8.dp)
        )

    }
}

@Preview
@Composable
private fun HomePrev() {
    Home()
}
