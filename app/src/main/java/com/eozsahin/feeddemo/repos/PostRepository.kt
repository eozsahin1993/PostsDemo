package com.eozsahin.feeddemo.repos

import android.util.Log
import androidx.lifecycle.LiveData
import com.eozsahin.feeddemo.api.BackendApi
import com.eozsahin.feeddemo.models.Post
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.Executor

class PostRepository(
    val api: BackendApi,
) {

    suspend fun getPosts() = api.getAllPosts()

}