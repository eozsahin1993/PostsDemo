package com.eozsahin.feeddemo.repos

import com.eozsahin.feeddemo.api.BackendService
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
    // add caching as well

     fun getPosts(callback: (List<Post>) -> Unit) {
         CoroutineScope(Dispatchers.IO).launch {
             val postData = getAllPosts().shuffled()
             val commentData = getAllComments()

             val posts = postData.map { post ->
                 val user = getUser(post.userId)
                 val postComments = commentData.filter { it.postId == post.id }

                 Post(
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