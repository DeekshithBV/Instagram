package com.example.instagram.data.repository

import android.net.Uri
import android.util.Log
import com.example.instagram.domain.repository.PostRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.util.*
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val storage: FirebaseStorage,
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) : PostRepository {

    override suspend fun uploadPost(imageUri: Uri, caption: String, onSuccess: () -> Unit) {
        try {
            val uid = auth.currentUser?.uid ?: return
            val filename = UUID.randomUUID().toString()
            val ref = storage.reference.child("posts/$uid/$filename.jpg")

            // Upload image to Firebase Storage
            ref.putFile(imageUri).await()
            val downloadUrl = ref.downloadUrl.await().toString()

            // Create post map
            val post = hashMapOf(
                "imageUrl" to downloadUrl,
                "caption" to caption,
                "uid" to uid,
                "timestamp" to System.currentTimeMillis()
            )

            // Add to Firestore
            firestore.collection("posts").add(post).await()
            onSuccess()
        } catch (e: Exception) {
            Log.e("UploadPost", "Upload failed", e)
        }
    }
}
