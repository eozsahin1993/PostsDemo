package com.eozsahin.feeddemo.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eozsahin.feeddemo.repos.getPostDetailRepository
import com.eozsahin.feeddemo.repos.getPostRepository
import com.eozsahin.feeddemo.repos.getUserRepository
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.models.PostDetail
import kotlinx.coroutines.launch

class PostDetailsViewModel(private val postId: String): ViewModel() {
    val post: MutableState<PostDetail> = mutableStateOf(PostDetail())

    init {
        viewModelScope.launch {
            getPostDetailRepository().getPostDetails(postId) {
                post.value = it
            }
        }
    }
}