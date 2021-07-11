package com.eozsahin.feeddemo.api

import com.eozsahin.feeddemo.data.CommentData
import com.eozsahin.feeddemo.data.PostData
import com.eozsahin.feeddemo.data.UserData
import retrofit2.http.*

interface BackendService {

    // POSTS

    @GET("/posts")
    suspend fun getAllPosts(): List<PostData>

    @GET("/posts")
    suspend fun getAllPostsByUser(@Query("userId") userId: String): List<PostData>

    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") postId: String): PostData

    @DELETE("/posts/{id}")
    suspend fun deletePost(@Path("id") postId: String)

    @POST("/posts")
    suspend fun createPost(@Body postData: PostData): PostData

    @PUT("/posts/{id}")
    suspend fun updatePost(@Path("id") postId: String, @Body postData: PostData): PostData

    // COMMENTS
    @GET("/comments")
    suspend fun getAllComments(): List<CommentData>

    @GET("/posts/{id}/comments")
    suspend fun getCommentsForPost(@Path("id") postId: String): List<CommentData>

    @POST("/comments")
    suspend fun addComment(@Body comment: CommentData): CommentData

    @DELETE("/comments/{id}")
    suspend fun deleteComment(@Path("id") commentId: String)

    @PUT("/comments/{id}")
    suspend fun updateComment(@Path("id") commentId: String, @Body comment: CommentData): CommentData

    // USERS

    @GET("/users/{id}")
    suspend fun getUserWithId(@Path("id") userId: Int): UserData
}