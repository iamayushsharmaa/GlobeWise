package com.example.globewise.view.home.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun ForYou() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue), // Set background color to blue
        contentAlignment = Alignment.Center // Align content to the center
    ) {
        Text(
            text = "For you", // Replace with your desired text
            color = Color.White, // Text color for better contrast
            fontSize = 24.sp, // Text size
            fontWeight = FontWeight.Bold // Optional: Make text bold
        )
    }
}