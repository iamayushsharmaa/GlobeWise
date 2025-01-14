package com.example.globewise.view.home.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.globewise.ui.theme.poppinsFontFamily
import com.example.globewise.view.home.card.SearchField
import com.example.globewise.view.home.tabs.Business
import com.example.globewise.view.home.tabs.Entertainment
import com.example.globewise.view.home.tabs.ForYou
import com.example.globewise.view.home.tabs.Health
import com.example.globewise.view.home.tabs.Science
import com.example.globewise.view.home.tabs.Sports
import com.example.globewise.view.home.tabs.TabItem
import com.example.globewise.view.home.tabs.Technology

@Composable
fun Explore(
    navController: NavController
) {

    val tabItems = listOf(
        TabItem(
            title = "For You"
        ),
        TabItem(
            title = "Sports"
        ),
        TabItem(
            title = "Entertainment"
        ),
        TabItem(
            title = "Business"
        ),
        TabItem(
            title = "Health"
        ),
        TabItem(
            title = "Science"
        ),
        TabItem(
            title = "Technology"
        ),
    )
    var selectedTabIndex by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState { tabItems.size }

    LaunchedEffect (selectedTabIndex){
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    Scaffold (modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color.White),
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = "Explore",
                    fontFamily = poppinsFontFamily,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 7.dp)
                )
                Text(
                    text = "News from around the world.",
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(horizontal = 7.dp)
                )

                SearchField(
                    modifier = Modifier.padding(top = 8.dp),
                    onSearchClick = {
                        navController.navigate("search")
                    }
                )
            }
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color.White,
                contentColor = Color.Black,
            ) {
                tabItems.forEachIndexed { index, item ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = {
                            Text(
                                text = item.title,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }
                    )
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { index ->
                when (index) {
                    0 -> ForYou()
                    1 -> Sports()
                    2 -> Entertainment()
                    3 -> Business()
                    4 -> Health()
                    5 -> Science()
                    6 -> Technology()
                }
            }
        }
    }
}

@Preview
@Composable
private fun ExplorePreview() {
    Explore(navController = rememberNavController())
}