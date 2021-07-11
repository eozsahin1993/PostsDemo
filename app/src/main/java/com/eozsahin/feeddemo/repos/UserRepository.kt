package com.eozsahin.feeddemo.repos

import com.eozsahin.feeddemo.api.BackendService
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val service: BackendService) {

    fun getUser(id: Int, callback: (User) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val userData = getUser(id)
            val user = User(
                id = userData.id,
                name = userData.name,
                userName = userData.userName,
                email = userData.email,
                profileImgUrl = "https://randomuser.me/api/portraits/men/${userData.id}.jpg"
            )
            callback(user)
        }
    }

    private suspend fun getUser(id: Int) = service.getUserWithId(id)

}