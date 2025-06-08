package com.example.instagram.data.repository

import com.example.instagram.domain.model.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    suspend fun login(email: String, password: String): AuthResult {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            AuthResult(isSuccess = true)
        } catch (e: Exception) {
            AuthResult(errorMessage = e.message)
        }
    }

    suspend fun signUp(email: String, password: String): AuthResult {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            AuthResult(isSuccess = true)
        } catch (e: Exception) {
            AuthResult(errorMessage = e.message)
        }
    }

    fun isUserLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }
}
