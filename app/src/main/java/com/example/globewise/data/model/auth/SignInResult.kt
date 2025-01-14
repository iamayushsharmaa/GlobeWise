package com.example.globewise.data.model.auth

import android.net.Uri

data class SignInResult(
    val data: UserData?,
    val errorMessage : String?
)
data class UserData (
    val userId : String?,
    val userName : String?,
    val userEmail : String?,
    val profilePhoto : Uri?
)