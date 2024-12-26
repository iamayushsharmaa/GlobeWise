package com.example.globewise.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.globewise.data.model.SignInState
import com.example.globewise.ui.theme.GlobeWiseTheme
import com.example.globewise.view.auth.Login
import com.example.globewise.viewmodel.SignInViewModel
import com.example.globewise.view.auth.StartingPage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlobeWiseTheme {
                val navController  = rememberNavController()
                val signInViewModel = hiltViewModel<SignInViewModel>()
                val signInState by signInViewModel.signInState.observeAsState(SignInState())

                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartIntentSenderForResult(),
                    onResult = { result ->
                        signInViewModel.handleSignInResult(result)
                    }
                )

                LaunchedEffect(key1 = signInState.isSignInSuccessful) {
                    if (signInState.isSignInSuccessful) {
                        //showToast(applicationContext, "Sign in successful")
                        navController.navigate("home")
                        signInViewModel.resetState()
                    }
                }

                NavHost(navController = navController, startDestination = "starting_page") {
                    composable("starting_page") {
                        StartingPage(
                            navController,
                            onGoogleSignInClick = {
                                signInViewModel.onGoogleSignInClick(launcher)
                            }
                        )
                    }
                    composable("login") {
                        Login(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
