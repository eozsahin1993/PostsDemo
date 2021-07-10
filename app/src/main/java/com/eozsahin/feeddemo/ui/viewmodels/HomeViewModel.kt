package com.eozsahin.feeddemo.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eozsahin.feeddemo.models.Post
import com.eozsahin.feeddemo.repos.getPostRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    val posts: MutableState<List<Post>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            posts.value = getPostRepository().getPosts()
        }
    }
}