package com.example.instagram.domain.model

data class AuthResult(
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)
