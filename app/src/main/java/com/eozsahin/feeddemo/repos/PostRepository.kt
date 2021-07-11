package com.eozsahin.feeddemo.repos

import com.eozsahin.feeddemo.api.BackendService
import com.eozsahin.feeddemo.data.PostData
import com.eozsahin.feeddemo.data.UserData
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PostRepository(
    private val service: BackendService,
) {
    companion object {
        val USER_CACHE = hashMapOf<Int, UserData>()
    }

    fun getPosts(callback: (List<Post>) -> Unit) {
         CoroutineScope(Dispatchers.IO).launch {
             val postData = getAllPosts().shuffled()
             val commentData = getAllComments()

             val posts = postData.map { post ->
                 val user = getUser(post.userId)
                 val postComments = commentData.filter { it.postId == post.id }

                 Post(
                     id = post.id,
                     title = post.title,
                     body = post.body,
                     likes = (1..100).random(),
                     comments = postComments.size,
                     userName = user.name,
                     userImgUrl = "https://randomuser.me/api/portraits/med/men/${user.id}.jpg"
                 )
             }
             callback(posts)
         }
    }

    suspend fun createPost(userId: Int, post: Post): Post {
        val postData = createPostInternal(userId, post)
        val user = getUser(userId)

        return Post(
            id = postData.id,
            title = postData.title,
            body = postData.body,
            likes = (1..100).random(),
            comments = 0,
            userName = user.name,
            userImgUrl = "https://randomuser.me/api/portraits/med/men/${userId}.jpg"
        )
    }

    private suspend fun createPostInternal(userId: Int, post: Post): PostData {
        val postData = PostData(body = post.body, title = post.title, userId = userId, id = 0)
        return service.createPost(postData)
    }

    private suspend fun getAllPosts() = service.getAllPosts()

    private suspend fun getAllComments() = service.getAllComments()

    private suspend fun getUser(id: Int): UserData {
        if (USER_CACHE.containsKey(id)) {
            return USER_CACHE[id] ?: UserData()
        }

        val user = service.getUserWithId(id)
        USER_CACHE[id] = user

        return user
    }
}