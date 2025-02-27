package com.example.globewise.data.model.auth

import com.google.firebase.auth.FirebaseUser

sealed class AuthResult {
    data class Success(val user: FirebaseUser?) : AuthResult()
    data class Error(val message: String) : AuthResult()
}
