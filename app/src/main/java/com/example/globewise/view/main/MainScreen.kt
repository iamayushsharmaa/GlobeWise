package com.example.globewise.view.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.globewise.view.data.BottomNavItem
import com.example.globewise.view.home.bottomnav.Bookmark
import com.example.globewise.view.home.bottomnav.BottomNavigationBar
import com.example.globewise.view.home.bottomnav.Explore
import com.example.globewise.view.home.bottomnav.Home
import com.example.globewise.view.home.bottomnav.Profile
import com.example.globewise.view.home.bottomnav.Search

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {
    var currentRoute by remember { mutableStateOf(BottomNavItem.Home.route) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentRoute,
                onItemSelected = { navItem -> currentRoute = navItem.route }
            )
        }
    ) {
        when (currentRoute) {
            BottomNavItem.Home.route -> Home()
            BottomNavItem.Search.route -> Explore()
            BottomNavItem.Bookmark.route -> Bookmark()
            BottomNavItem.Profile.route -> Profile()
        }
    }
}
