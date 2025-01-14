package com.example.globewise.view.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.globewise.data.model.auth.SignInState
import com.example.globewise.ui.theme.GlobeWiseTheme
import com.example.globewise.view.auth.Login
import com.example.globewise.viewmodel.SignInViewModel
import com.example.globewise.view.auth.StartingPage
import com.example.globewise.view.data.BottomNavItem
import com.example.globewise.view.home.bottomnav.Search
import com.example.globewise.viewmodel.EmailSignInViewModel
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
                val emailSignInViewModel = hiltViewModel<EmailSignInViewModel>()
                val signInState by signInViewModel.signInState.observeAsState(SignInState())
                val isUserSignedIn by emailSignInViewModel.isUserSignedIn.collectAsState()
                val startDestination = if (isUserSignedIn) "main_screen" else "starting_page"

                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartIntentSenderForResult(),
                    onResult = { result ->
                        signInViewModel.handleSignInResult(result)
                    }
                )

                LaunchedEffect(key1 = signInState.isSignInSuccessful) {
                    if (signInState.isSignInSuccessful) {
                        Toast.makeText(applicationContext, "Sign in successful",Toast.LENGTH_SHORT).show()
                        navController.navigate("main_screen"){
                            popUpTo("starting_page") { inclusive = true }
                        }
                        signInViewModel.resetState()
                    }
                }

                NavHost(navController = navController, startDestination = startDestination) {
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
                    composable("main_screen"){
                        MainScreen(navController)
                    }
                    composable("search"){
                        Search(navController)
                    }
                }
            }
        }
    }
}
