package com.example.globewise.view.data

import com.example.globewise.R

sealed class BottomNavItem(
    val route: String,
    val filledIcon: Int,
    val outlineIcon: Int,
    val title: String
) {
    object Home : BottomNavItem("home", R.drawable.icon_homefilled, R.drawable.icon_homeblank, "Home")
    object Search : BottomNavItem("search", R.drawable.icon_searchfilled, R.drawable.icon_searchblank, "Search")
    object Bookmark : BottomNavItem("bookmark", R.drawable.icon_savefilled, R.drawable.icon_saveblank, "Bookmark")
    object Profile : BottomNavItem("profile", R.drawable.icon_profilefilled, R.drawable.icon_profileblank, "Profile")
}
