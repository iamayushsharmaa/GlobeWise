package com.example.globewise.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globewise.ui.theme.poppinsFontFamily
import com.example.globewise.view.home.card.SearchField

@Composable
fun Explore(){
    Column {
        Text(
            text = "Explore",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 5.dp, start = 8.dp)
        )
        Text(
            text = "News from around the world",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 5.dp, start = 8.dp)
        )

        SearchField(
            modifier = Modifier.padding(8.dp),
            onSearchClick = {}
        )


    }
}