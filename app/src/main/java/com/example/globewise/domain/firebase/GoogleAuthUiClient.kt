package com.example.globewise.domain.firebase

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.example.globewise.R
import com.example.globewise.data.model.auth.SignInResult
import com.example.globewise.data.model.auth.UserData
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import java.util.concurrent.CancellationException
import javax.inject.Inject


@Suppress("DEPRECATION")
class GoogleAuthUiClient @Inject constructor(
    private val auth : FirebaseAuth,
    private val context: Context,
    private val oneTapClient : SignInClient,
    private val saveAuthFb: SaveAuthFb
){

    suspend fun SignIn(): IntentSender?{
        val result = try {
            oneTapClient.beginSignIn(
                buildSignInRequest()
            ).await()
        }catch (e : Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            null
        }
        return result?.pendingIntent?.intentSender
    }

    fun getSignedInUser(): UserData? = auth.currentUser?.run {
        UserData(
            userId = uid,
            userName = displayName,
            profilePhoto = photoUrl,
            userEmail = email
        )
    }
    suspend fun SignInWithIntent(intent : Intent): SignInResult {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredential = GoogleAuthProvider.getCredential(googleIdToken,null)
        return try {
            val user = auth.signInWithCredential(googleCredential).await().user

            user?.let {
                saveAuthFb.saveUserData(
                    uid = it.uid,
                    name = it.displayName.orEmpty(),
                    email = it.email.orEmpty(),
                    profilePhoto = it.photoUrl
                )
            }
            SignInResult(
                data = user?.run {
                    UserData(
                        userId = uid,
                        userName = displayName,
                        userEmail = email,
                        profilePhoto = photoUrl
                    )
                },
                errorMessage = null
            )
        }catch (e : Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            SignInResult(
                data = null,
                errorMessage = e.message
            )
        }
    }
    private fun buildSignInRequest(): BeginSignInRequest {

        return BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(context.getString(R.string.web_client_id))
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
    }

    suspend fun signOut(){
        try {
            oneTapClient.signOut().await()
            auth.signOut()
        }catch (e : Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            null
        }
    }

}