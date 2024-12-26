package com.example.globewise.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globewise.R
import com.example.globewise.ui.theme.poppinsFontFamily

@Composable
fun StartingPage() {
    Scaffold (
        modifier = Modifier
            .fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color.White),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "GlobeWise.",
                modifier = Modifier.fillMaxWidth(),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    onClick = {}
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_google),
                            contentDescription = "icon google"
                        )
                        Text(
                            text = "Continue with Google",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    onClick = {}
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_email),
                            tint = Color.White,
                            contentDescription = "icon google"
                        )
                        Text(
                            text = "Email and Password",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }


            }

        }
    }
}