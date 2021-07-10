package com.eozsahin.feeddemo.api

import com.eozsahin.feeddemo.models.Comment
import com.eozsahin.feeddemo.models.Post
import retrofit2.Call
import retrofit2.http.*

interface BackendApi {

    // POSTS

    @GET("/posts")
    suspend fun getAllPosts(): List<Post>

    @GET("/posts")
    suspend fun getAllPostsByUser(@Query("userId") userId: String): List<Post>

    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") postId: String): Post

    @DELETE("/posts/{id}")
    suspend fun deletePost(@Path("id") postId: String)

    @POST("/posts")
    suspend fun createPost(@Body post: Post): Post

    @PUT("/posts/{id}")
    suspend fun updatePost(@Path("id") postId: String, @Body post: Post): Post

    // COMMENTS

    @GET("/posts/{id}/comments")
    suspend fun getCommentsForPost(@Path("id") postId: String): List<Comment>

    @POST("/comments")
    suspend fun addComment(@Body comment: Comment): Comment

    @DELETE("/comments/{id}")
    suspend fun deleteComment(@Path("id") commentId: String)

    @PUT("/comments/{id}")
    suspend fun updateComment(@Path("id") commentId: String, @Body comment: Comment): Comment







}