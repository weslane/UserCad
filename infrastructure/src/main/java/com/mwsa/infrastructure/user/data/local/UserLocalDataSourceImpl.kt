package com.mwsa.infrastructure.user.data.local

import com.mwsa.infrastructure.data.LocalDataSource
import com.mwsa.infrastructure.data.LocalDataSourceImpl
import com.mwsa.infrastructure.user.UserLocalDataSource
import com.mwsa.infrastructure.user.model.UserEntity


class UserLocalDataSourceImpl : UserLocalDataSource,
    LocalDataSource<UserEntity> by LocalDataSourceImpl(UserEntity::class.java)