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
import com.example.globewise.view.home.Bookmark
import com.example.globewise.view.home.BottomNavigationBar
import com.example.globewise.view.home.Home
import com.example.globewise.view.home.Profile
import com.example.globewise.view.home.Search

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
            BottomNavItem.Search.route -> Search()
            BottomNavItem.Bookmark.route -> Bookmark()
            BottomNavItem.Profile.route -> Profile()
        }
    }
}