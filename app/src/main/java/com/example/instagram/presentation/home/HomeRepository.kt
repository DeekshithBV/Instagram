package com.example.instagram.presentation.home

import com.example.instagram.data.model.Post
import javax.inject.Inject

class HomeRepository @Inject constructor() {

    fun getPosts(): List<Post> {
        return listOf(
            Post("1", "john_doe", "https://picsum.photos/id/237/600/400", "Enjoying the day!"),
            Post("2", "jane_doe", "https://picsum.photos/id/238/600/400", "Lovely sunset 🌅")
        )
    }
}
