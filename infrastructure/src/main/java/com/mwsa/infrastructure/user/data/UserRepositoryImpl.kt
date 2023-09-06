package com.mwsa.infrastructure.user.data

import com.mwsa.domain.user.UserRepository
import com.mwsa.domain.user.models.User
import com.mwsa.infrastructure.user.UserLocalDataSource
import com.mwsa.infrastructure.user.UserRemoteDataSource
import com.mwsa.infrastructure.user.mapper.toApiDto
import com.mwsa.infrastructure.user.mapper.toDomain
import com.mwsa.infrastructure.user.mapper.toUserEntity

class UserRepositoryImpl (
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource,
) : UserRepository{
    override suspend fun getUsers(): List<User> {
        return localDataSource.getAll().map { it.toDomain() }
    }

    override suspend fun postUser(user: User) {
        val userEntity = user.toUserEntity()
        localDataSource.save(userEntity)
        remoteDataSource.updateUser(userEntity.toApiDto())
    }

}
