package com.mwsa.infrastructure.user

import com.mwsa.infrastructure.data.LocalDataSource
import com.mwsa.infrastructure.user.model.UserApiDto
import com.mwsa.infrastructure.user.model.UserEntity

interface UserLocalDataSource : LocalDataSource<UserEntity>

interface UserRemoteDataSource {

    suspend fun createUser(user: UserApiDto)

    suspend fun updateUser(user: UserApiDto)

    suspend fun deleteUser(user: UserApiDto)

}
