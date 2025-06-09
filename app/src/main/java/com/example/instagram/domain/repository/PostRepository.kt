package com.example.instagram.domain.repository

import android.net.Uri

interface PostRepository {
    suspend fun uploadPost(imageUri: Uri, caption: String, onSuccess: () -> Unit)
}
