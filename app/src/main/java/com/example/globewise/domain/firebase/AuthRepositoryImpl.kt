package com.example.globewise.domain.firebase

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
): AuthRepository {

    override suspend fun registerUser(email: String, password: String): AuthResult {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            result
        } catch (e: Exception) {
            throw Exception("Registration failed: ${e.message}")
        }
    }

    override suspend fun loginUser(email: String, password: String): AuthResult {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            result
        } catch (e: Exception) {
            throw Exception("Login failed: ${e.message}")
        }
    }

    fun getCurrentUser() = auth.currentUser
}