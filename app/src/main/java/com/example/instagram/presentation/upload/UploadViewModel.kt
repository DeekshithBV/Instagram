package com.example.instagram.presentation.upload

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagram.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UploadViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    fun uploadPost(
        imageUri: Uri,
        caption: String,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            postRepository.uploadPost(imageUri, caption, onSuccess)
        }
    }
}
