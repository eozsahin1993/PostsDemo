package com.eozsahin.feeddemo.repos

import com.eozsahin.feeddemo.api.BackendService
import com.eozsahin.feeddemo.data.CommentData
import com.eozsahin.feeddemo.ui.models.Comment
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.models.PostDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostDetailRepository(
    private val service: BackendService
) {
    fun getPostDetails(postId: String, callback: (PostDetail) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val postData = getPostById(postId)
            val postComments = getPostComments(postId)
            val userData = getUserById(postData.userId)

            val postDetail = PostDetail(
                id = postData.id,
                title = postData.title,
                body = postData.body,
                likes = (1..100).random(),
                comments = parseComments(postComments),
                userName = userData.name,
                userImgUrl = "https://randomuser.me/api/portraits/med/men/${userData.id}.jpg"
            )

            callback(postDetail)
        }
    }

    private fun parseComments(comments: List<CommentData>): List<Comment> {
        return comments.map {
            Comment(
                id = it.id,
                userName = it.name,
                body = it.body,
                userImgUrl = ""
            )
        }
    }

    private suspend fun getPostById(id: String) = service.getPost(id)

    private suspend fun getPostComments(postId: String) = service.getCommentsForPost(postId)

    private suspend fun getUserById(id: Int) = service.getUserWithId(id)

}