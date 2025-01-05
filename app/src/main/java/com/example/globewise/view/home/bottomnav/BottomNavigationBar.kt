package com.example.globewise.view.home.bottomnav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.globewise.view.data.BottomNavItem

@Composable
fun BottomNavigationBar(
    currentRoute: String,
    onItemSelected: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Bookmark,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = if (isSelected) item.filledIcon else item.outlineIcon),
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selected = isSelected,
                onClick = { onItemSelected(item) },
                alwaysShowLabel = true,
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray
            )
        }
    }
}

