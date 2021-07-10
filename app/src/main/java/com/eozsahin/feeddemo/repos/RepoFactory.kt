package com.eozsahin.feeddemo.repos

import com.eozsahin.feeddemo.api.BackendApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import java.util.concurrent.Executors

val EXECUTOR = Executors.newFixedThreadPool(3)
val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com")
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .build()
val api = retrofit.create(BackendApi::class.java)

fun getPostRepository(): PostRepository {
    return PostRepository(api)
}