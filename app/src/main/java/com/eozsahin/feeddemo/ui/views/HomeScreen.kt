package com.eozsahin.feeddemo.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eozsahin.feeddemo.ui.components.PostCardView
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.viewmodels.HomeViewModel

@Composable
fun homeScreen(model: HomeViewModel = HomeViewModel(), navController: NavController) {
    showPosts(posts = model.posts.value, navController)
}

@Composable
fun showPosts(posts: List<Post>, navController: NavController) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(posts) { post ->
            PostCardView(post, shape = RoundedCornerShape(0.dp)) {
                navController.navigate("posts/${post.id}")
            }
        }
    }
}





