package com.example.globewise.view.home.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globewise.ui.theme.poppinsFontFamily
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
        modifier = Modifier.padding(5.dp), backgroundColor = Color.White
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            BottomNavigationItem(
                modifier = Modifier
                    .height(70.dp)
                    .padding(bottom = 7.dp),
                icon = {
                    Icon(
                        painter = painterResource(id = if (isSelected) item.filledIcon else item.outlineIcon),
                        contentDescription = item.title,
                        modifier = Modifier.size(28.dp),
                        tint = if (isSelected) Color.Black else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontFamily = poppinsFontFamily,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(top = 4.dp),
                        color = if (isSelected) Color.Black else Color.Gray
                    )
                },
                selected = isSelected,
                onClick = { onItemSelected(item) },
                alwaysShowLabel = true,
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray
            )
        }
    }
}
