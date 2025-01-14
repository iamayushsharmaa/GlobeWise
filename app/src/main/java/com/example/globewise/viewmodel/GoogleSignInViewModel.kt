package com.example.globewise.viewmodel

import android.app.Activity.RESULT_OK
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globewise.data.model.auth.SignInState
import com.example.globewise.data.model.auth.UserData
import com.example.globewise.domain.firebase.GoogleAuthUiClient
import com.example.globewise.domain.firebase.SaveAuthFb
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val googleAuthUiClient: GoogleAuthUiClient,
    private val mAuth: FirebaseAuth,
) : ViewModel() {

    private val _signInState = MutableLiveData<SignInState>()
    val signInState: LiveData<SignInState> get() = _signInState

    private val _userData = MutableStateFlow<UserData?>(null)
    val userData: StateFlow<UserData?> = _userData

    init {
        _userData.value = googleAuthUiClient.getSignedInUser()
    }

    fun onGoogleSignInClick(launcher: ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>) {
        viewModelScope.launch {
            val signInIntentSender = googleAuthUiClient.SignIn()
            signInIntentSender?.let {
                val intentSenderRequest = IntentSenderRequest.Builder(it).build()
                launcher.launch(intentSenderRequest)
            }
        }
    }

    fun handleSignInResult(result: ActivityResult) {
        if (result.resultCode == RESULT_OK) {
            viewModelScope.launch {
                val signInResult = result.data?.let { googleAuthUiClient.SignInWithIntent(it) }
                signInResult?.let {
                    onSignInSuccess()
                }
            }
        } else {
            onSignInFailure()
        }
    }

    private fun onSignInSuccess() {
        _signInState.value = SignInState(isSignInSuccessful = true)
    }

    private fun onSignInFailure() {
        _signInState.value = SignInState(isSignInSuccessful = false)
    }

    fun resetState() {
        _signInState.value = SignInState(isSignInSuccessful = false)
    }

    fun signOut() {
        viewModelScope.launch {
            googleAuthUiClient.signOut()
            _signInState.value = SignInState(isSignInSuccessful = false)
        }
    }
}
