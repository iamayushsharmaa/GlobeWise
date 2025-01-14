package com.example.globewise.domain.firebase

import com.example.globewise.data.model.auth.AuthResult
import com.google.firebase.auth.FirebaseUser


interface AuthRepository {
    suspend fun registerUser(email: String, password: String, name: String): AuthResult
    suspend fun loginUser(email: String, password: String): AuthResult
    suspend fun getCurrentUser(): FirebaseUser?
}