package com.example.instagram.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagram.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AuthUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState

    fun login(email: String, password: String) {
        _uiState.value = AuthUiState(isLoading = true)
        viewModelScope.launch {
            val result = repository.login(email, password)
            _uiState.value = AuthUiState(
                isSuccess = result.isSuccess,
                error = result.errorMessage
            )
        }
    }

    fun signUp(email: String, password: String) {
        _uiState.value = AuthUiState(isLoading = true)
        viewModelScope.launch {
            val result = repository.signUp(email, password)
            _uiState.value = AuthUiState(
                isSuccess = result.isSuccess,
                error = result.errorMessage
            )
        }
    }

    fun checkSession(): Boolean = repository.isUserLoggedIn()
}
