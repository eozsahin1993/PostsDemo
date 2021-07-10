package com.eozsahin.feeddemo.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.models.Post
import com.eozsahin.feeddemo.ui.components.getPostCard
import com.eozsahin.feeddemo.ui.viewmodels.HomeViewModel

@Preview
@Composable
fun homeScreen(model: HomeViewModel) {
    showPosts(posts = model.posts.value)
}

@Preview
@Composable
fun showPosts(posts: List<Post>) {
    LazyColumn {
        items(posts) { post ->
            getPostCard(post)
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}





