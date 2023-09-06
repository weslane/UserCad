package com.mwsa.infrastructure.user.data.remote

import com.mwsa.infrastructure.user.UserRemoteDataSource
import com.mwsa.infrastructure.user.model.UserApiDto

class UserRemoteDataSourceImpl(private val api: UserApi) : UserRemoteDataSource {
    override suspend fun createUser(user: UserApiDto) {
        api.getUsers()
    }

    override suspend fun updateUser(user: UserApiDto) {
        api.postUser(user)
    }

}