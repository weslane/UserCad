package com.mwsa.domain.user

import com.mwsa.domain.user.models.User

interface UserRepository {

    suspend fun getUsers(): List<User>
    suspend fun postUser()
}