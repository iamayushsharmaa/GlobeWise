package com.example.globewise.domain.firebase

import com.example.globewise.data.model.AuthResult


interface AuthRepository {
    suspend fun registerUser(email: String, password: String): AuthResult
    suspend fun loginUser(email: String, password: String): AuthResult
}