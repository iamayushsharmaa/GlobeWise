package com.example.globewise.domain.firebase

import com.example.globewise.data.model.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {

    override suspend fun registerUser(email: String, password: String): AuthResult {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            AuthResult.Success(result.user)
        } catch (e: Exception) {
            AuthResult.Error("Registration failed: ${e.message}")
        }
    }

    override suspend fun loginUser(email: String, password: String): AuthResult {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            AuthResult.Success(result.user)
        } catch (e: Exception) {
            AuthResult.Error("Login failed: ${e.message}")
        }
    }
    override suspend fun getCurrentUser(): FirebaseUser? = auth.currentUser
}
