package com.example.globewise.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globewise.data.model.auth.AuthResult
import com.example.globewise.data.model.auth.AuthState
import com.example.globewise.data.model.auth.User
import com.example.globewise.domain.firebase.AuthRepository
import com.example.globewise.domain.firebase.SaveUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmailSignInViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val firestoreDb: SaveUserRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState
    private val _isUserSignedIn = MutableStateFlow(false)
    val isUserSignedIn: StateFlow<Boolean> = _isUserSignedIn

    init {
        viewModelScope.launch {
            _isUserSignedIn.value = repository.getCurrentUser() != null
        }
    }
    fun registerUser(email: String, password: String, name: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val authResult = repository.registerUser(email, password)
            when (authResult) {
                is AuthResult.Success -> {
                    val user = User(
                        email = email,
                        password = password,
                        name = name
                    )
                    try {
                        firestoreDb.saveUser(user)
                        _authState.value = AuthState.Success("User registered successfully")
                    } catch (e: Exception) {
                        _authState.value = AuthState.Error("User saved in Firestore failed: ${e.message}")
                    }
                }
                is AuthResult.Error -> {
                    _authState.value = AuthState.Error(authResult.message)
                }
            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val authResult = repository.loginUser(email, password)
            when (authResult) {
                is AuthResult.Success -> {
                    _authState.value = AuthState.Success("User logged in successfully")
                }
                is AuthResult.Error -> {
                    _authState.value = AuthState.Error(authResult.message)
                }
            }
        }
    }
}


