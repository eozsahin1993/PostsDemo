package com.eozsahin.feeddemo.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.ui.components.CommentView
import com.eozsahin.feeddemo.ui.components.PostCardView
import com.eozsahin.feeddemo.ui.models.Comment
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.models.PostDetail
import com.eozsahin.feeddemo.ui.viewmodels.PostDetailsViewModel

@Composable
fun PostDetailsScreen(model: PostDetailsViewModel) {
    PostDetails(model.post.value)
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PostDetails(
    @PreviewParameter(PostDetailsProvider::class) postDetail: PostDetail
) {
    val list = mutableListOf(postDetail.toPost()) + postDetail.comments
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(list) {
            when (it) {
                is Post -> PostCardView(post = postDetail.toPost(), shape = RoundedCornerShape(0.dp))
                is Comment -> CommentView(it)
                else -> Text("error")
            }
        }
    }
}

class PostDetailsProvider: PreviewParameterProvider<PostDetail> {
    override val values = sequenceOf(getPostDetail())

    private fun getPostDetail() = PostDetail(
        id = 1,
        title = "How I traveled around the world",
        body = "One morning, when Gregor Samsa woke from troubled dreams, he found himself " +
                "transformed in his bed into a horrible vermin. He lay on his armour-like back, " +
                "and if he lifted his head a little he could see his brown belly, slightly domed " +
                "and divided by arches into stiff sections. The bedding was hardly able to cover" +
                " it and seemed ready to slide off any moment. His many legs, pitifully thin " +
                "compared with the size of the rest of him, waved about helplessly as he " +
                "looked. \"What's happened to me?\" he thought. ",
        likes = 20,
        userName = "Franz Kafka",
        comments = listOf(
            Comment(id = 1, "Dexter Morgan", body = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", userImgUrl = ""),
            Comment(id = 2, "Jules Verne", body = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. ", userImgUrl = ""),
            Comment(id = 3, "Jules Verne", body = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure ", userImgUrl = "")
        )
    )
}
