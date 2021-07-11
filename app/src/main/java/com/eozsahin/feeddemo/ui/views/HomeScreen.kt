package com.eozsahin.feeddemo.ui.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.data.PostData
import com.eozsahin.feeddemo.ui.components.getPostCard
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.viewmodels.HomeViewModel

@Composable
fun homeScreen(model: HomeViewModel) {
    showPosts(posts = model.posts.value)
}

@Composable
fun showPosts(posts: List<Post>) {
    LazyColumn {
        items(posts) { post ->
            getPostCard(post)
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}





