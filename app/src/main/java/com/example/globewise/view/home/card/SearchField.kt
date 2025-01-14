package com.example.globewise.view.home.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globewise.ui.theme.poppinsFontFamily

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onSearchClick() },
        contentAlignment = Alignment.CenterStart
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            enabled = false,
            placeholder = { Text(text = "Search...", fontFamily = poppinsFontFamily, fontSize = 14.sp) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, // Search icon
                    contentDescription = "Search",
                    tint = Color.Gray
                )
            },
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFD4D4D4),
                unfocusedContainerColor = Color(0xFFD4D4D4),
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black
            )
        )
    }
}
