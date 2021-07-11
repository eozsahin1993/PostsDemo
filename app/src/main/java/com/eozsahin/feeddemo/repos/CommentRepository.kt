package com.eozsahin.feeddemo.repos

import com.eozsahin.feeddemo.api.BackendService

class CommentRepository(val service: BackendService) {
    suspend fun getAllComments() {
        val commentData = service.getAllComments()

    }
}