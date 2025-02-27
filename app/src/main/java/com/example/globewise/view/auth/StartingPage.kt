package com.example.globewise.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.globewise.R
import com.example.globewise.ui.theme.poppinsFontFamily

@Composable
fun StartingPage(
    navController: NavController,
    onGoogleSignInClick: () -> Unit
) {
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
                        .height(75.dp)
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        onGoogleSignInClick()
                    }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_google),
                            modifier = Modifier.size(28.dp),
                            contentDescription = "icon google"
                        )
                        Text(
                            text = "Sign up with Google",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(start = 14.dp)
                        )
                    }
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        navController.navigate("login")
                    }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_email),
                            tint = Color.White,
                            modifier = Modifier.size(28.dp),
                            contentDescription = "icon google"
                        )
                        Text(
                            text = "Sign up with Email",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 14.dp)
                        )
                    }
                }
                Text(
                    text = "Already have an account? Sign in!",
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .clickable {
                            navController.navigate("login")
                        },
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
private fun StartPage() {

    StartingPage(
        navController = rememberNavController(),
        onGoogleSignInClick = {}
    )

}