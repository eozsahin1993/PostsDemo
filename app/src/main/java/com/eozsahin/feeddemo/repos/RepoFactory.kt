package com.eozsahin.feeddemo.repos

import com.eozsahin.feeddemo.api.BackendService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType
import retrofit2.Retrofit
import java.util.concurrent.Executors

val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com")
    .addConverterFactory(
        Json { ignoreUnknownKeys = true }.asConverterFactory(MediaType.get("application/json")))
    .build()
val api = retrofit.create(BackendService::class.java)

fun getPostRepository(): PostRepository {
    return PostRepository(api)
}

fun getUserRepository(): UserRepository {
    return UserRepository(api)
}

fun getPostDetailRepository(): PostDetailRepository {
    return PostDetailRepository(api)
}