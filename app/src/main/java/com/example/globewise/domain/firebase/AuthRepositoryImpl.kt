package com.example.globewise.domain.firebase

import com.example.globewise.data.model.auth.AuthResult
import com.example.globewise.data.model.auth.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val saveAuthFb: SaveAuthFb
    ) : AuthRepository {

    override suspend fun registerUser(email: String, password: String, name: String): AuthResult {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            result.user?.let { user ->
                saveAuthFb.saveUserData(user.uid, name, email,null)
            }

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
