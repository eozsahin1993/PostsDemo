package com.eozsahin.feeddemo.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eozsahin.feeddemo.repos.getPostRepository
import com.eozsahin.feeddemo.ui.models.Post
import kotlinx.coroutines.launch

class CreatePostViewModel: ViewModel() {

    suspend fun submitPost(userId: Int, post: Post): Post {
        return getPostRepository().createPost(userId, post)
    }
}