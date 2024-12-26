package com.example.globewise.data.model

data class SignInResult(
    val data: UserData?,
    val errorMessage : String?
)
data class UserData (
    val userId : String?,
    val userName : String?,
    val profilePhoto : String?
)