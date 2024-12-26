package com.example.globewise.domain.firebase

import com.example.globewise.data.model.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SaveUserRepository @Inject constructor(
    private val db : FirebaseFirestore
)  {
    suspend fun saveUser(user: User) {
        try {
            db.collection("Users")
                .document(user.email)
                .set(user)
                .await()
        } catch (e: Exception) {
            throw Exception("Error saving user to Firestore: ${e.message}")
        }
    }
}