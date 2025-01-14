package com.example.globewise.domain.firebase

import android.net.Uri
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SaveAuthFb @Inject constructor(
    private val database: FirebaseDatabase
) {
    suspend fun saveUserData(uid: String, name: String, email: String, profilePhoto: Uri?) {
        try {
            val userMap = mapOf(
                "uid" to uid,
                "name" to name,
                "email" to email,
                "profilePhoto" to profilePhoto
            )
            database.reference.child("users").child(uid).setValue(userMap).await()
        } catch (e: Exception) {
            // Handle error (e.g., log the error, rethrow, or return a result)
            throw Exception("Failed to save user data: ${e.message}")
        }
    }
}