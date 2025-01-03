package com.example.globewise.data.model.auth

data class SignInState(
    val isSignInSuccessful :Boolean = false,
    val signInError:String? = null
)