package com.example.globewise.view.home.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onSearchClick() }, // Navigate to another screen on click
        contentAlignment = Alignment.CenterStart // Align the text and icon to start
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            enabled = false,
            placeholder = { Text(text = "Search...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, // Search icon
                    contentDescription = "Search"
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledTextColor = Color.Transparent,
                disabledBorderColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
                disabledPlaceholderColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
            )
        )
    }
}
