package com.eozsahin.feeddemo.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eozsahin.feeddemo.data.PostData
import com.eozsahin.feeddemo.repos.getPostRepository
import com.eozsahin.feeddemo.ui.models.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val posts: MutableState<List<Post>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            getPostRepository().getPosts {
                posts.value = it
            }
        }
    }

}