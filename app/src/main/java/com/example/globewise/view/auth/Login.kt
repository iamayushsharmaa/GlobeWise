package com.example.globewise.view.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.globewise.data.model.AuthState
import com.example.globewise.ui.theme.poppinsFontFamily
import com.example.globewise.viewmodel.EmailSignInViewModel

@Composable
fun Login(
    viewModel: EmailSignInViewModel = hiltViewModel(),
    navController: NavController,
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    var isLoginScreen by remember { mutableStateOf(true) }

    val authState by viewModel.authState.collectAsState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            when (authState) {
                is AuthState.Loading -> {
                  ProgressDialogBox(
                      showDialog = true,
                      text = "Loading...",
                      onDismiss = {}
                  )
                }
                is AuthState.Success -> {
                    navController.navigate("homeScreen") {
                        popUpTo("login") { inclusive = true }
                    }
                }
                is AuthState.Error -> {
                    val errorMessage = (authState as AuthState.Error).message
                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
            Text(
                text = if (isLoginScreen) "Sign in." else "Sign up.",
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            if (!isLoginScreen) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = {
                        Text("Name", color = Color.Gray)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shadow(4.dp)
                        .background(Color.White)
                )
            }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text("Email", color = Color.Gray)
                },
                label = {Text("Email")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shadow(4.dp)
                    .background(Color.White)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text("Password", color = Color.Gray)
                },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shadow(4.dp)
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (isLoginScreen) {
                        viewModel.loginUser(email, password)
                    } else {
                        viewModel.registerUser(email, password, name)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shadow(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = if (isLoginScreen) "Sign in" else "Sign up",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = if (isLoginScreen) "Don't have an account? Sign up" else "Already have an account? Sign in",
                color = Color.Blue,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable { isLoginScreen = !isLoginScreen }
                    .padding(8.dp)
            )
        }
    }
}