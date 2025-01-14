package com.example.globewise.view.home.bottomnav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.globewise.R

@Composable
fun Search(navController: NavController) {

    var newsSearch by remember { mutableStateOf("") }

    Scaffold (
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_icon ),
                        contentDescription = "back icon",
                        modifier = Modifier
                            .size(28.dp)
                            .padding(5.dp)
                    )
                }
                OutlinedTextField(
                    value = newsSearch,
                    onValueChange = { newsSearch = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp)
                        .padding(end = 10.dp, top = 8.dp, ),
                    shape = RoundedCornerShape(22.dp),
                    placeholder = { Text(text = "Search news") },
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
    }
}