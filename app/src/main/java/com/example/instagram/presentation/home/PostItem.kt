package com.example.instagram.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.instagram.data.model.Post

@Composable
fun PostItem(post: Post) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(text = post.username, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = rememberAsyncImagePainter(post.imageUrl),
            contentDescription = "Post Image",
            modifier = Modifier.fillMaxWidth().height(300.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = post.caption, style = MaterialTheme.typography.bodyMedium)
    }
}
