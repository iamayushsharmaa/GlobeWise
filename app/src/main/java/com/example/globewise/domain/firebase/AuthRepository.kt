package com.example.globewise.domain.firebase

import com.google.firebase.auth.AuthResult


interface AuthRepository {
    suspend fun registerUser(email: String, password: String): AuthResult
    suspend fun loginUser(email: String, password: String): AuthResult
}