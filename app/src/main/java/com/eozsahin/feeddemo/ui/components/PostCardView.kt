package com.eozsahin.feeddemo.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.R
import com.eozsahin.feeddemo.data.PostData
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.theme.AppTypography
import androidx.compose.foundation.Image
import com.google.accompanist.glide.rememberGlidePainter

@Preview
@Composable
fun getPostCard(@PreviewParameter(PostProvider::class) post: Post) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            getPostCardHeader(post)
            getPostCardContent(post)
            getPostCardFooter(post)
        }
    }
}

@Composable
fun getPostCardHeader(post: Post) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(5.dp)
    ) {
        Image(
            painter = rememberGlidePainter(
                post.userImgUrl,
                fadeIn = true
            ),
            contentDescription = "UserImage",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(5.dp)) {
            Text(post.userName,
                style = AppTypography.body2,

            )
            Text("x seconds ago",
                style = AppTypography.caption,
                color = Color.Gray)
        }
    }
}

@Composable
fun getPostCardContent(post: Post) {
    Column {
        Text(
            post.title,
            style = AppTypography.subtitle1,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            post.body,
            modifier = Modifier.padding(start = 12.dp, end = 10.dp, bottom = 10.dp),
            style = AppTypography.caption
        )
    }
}

@Composable
fun getPostCardFooter(post: Post) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Filled.Favorite,
                "contentDescription",
                tint = Color.Magenta)
            Text("${post.likes} likes")

            Icon(
                Icons.Filled.QuestionAnswer,
                "contentDescription",
                tint = Color.Magenta)
            Text("${post.comments} comments")
        }

        Row(verticalAlignment =  Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
            Button(onClick = {
                Log.i("emre", "tapped")
            }, modifier = Modifier.clip(CircleShape)) {
                Text("Add comment", style = AppTypography.caption)
            }
        }
    }
}

class PostProvider: PreviewParameterProvider<Post> {
    override val values = sequenceOf(getPreviewPost())

    private fun getPreviewPost() = Post(
        title = "This is a post title",
        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation",
        likes = 15,
        comments = 20,
        userName = "Emre Ozsahin",
        userImgUrl = "https://picsum.photos/300/300"
    )
}


