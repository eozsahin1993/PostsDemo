package com.eozsahin.feeddemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Comment
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.R
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.theme.AppTypography
import com.eozsahin.feeddemo.ui.theme.Red300
import com.google.accompanist.glide.rememberGlidePainter

@Preview
@Composable
fun getPostCard(@PreviewParameter(PostProvider::class) post: Post) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 15.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            getPostCardHeader(post)
            getPostCardContent(post)
            getPostCardFooter(post)
        }
    }
}

@Composable
fun getPostCardHeader(post: Post) {
    Row(modifier = Modifier.fillMaxWidth()) {
        UserProfile(
            profileImgUrl = post.userImgUrl,
            userName = post.userName,
            imageModifier = Modifier.size(44.dp).clip(CircleShape)
        )
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = {}) {
                Icon(Icons.Default.MoreVert, contentDescription = "menu")
            }
        }
    }
}

@Composable
fun getPostCardContent(post: Post) {
    Column {
        Text(
            post.title,
            style = AppTypography.body1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            post.body,
            modifier = Modifier.padding(start = 12.dp, end = 10.dp, bottom = 10.dp),
            style = AppTypography.body1,
        )
    }
}

@Composable
fun getPostCardFooter(post: Post) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Rounded.Favorite,
                "contentDescription",
                tint = Red300,
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .size(30.dp)
            )
            Text(post.likes.toString(), color = Color.Gray, style = AppTypography.button)
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Icon(
                Icons.Rounded.Comment,
                "contentDescription",
                tint = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .size(30.dp)
            )
            Text("${post.comments}", color = Color.Gray, style = AppTypography.button)
        }

        Row(verticalAlignment =  Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Share, contentDescription = "fd")
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


