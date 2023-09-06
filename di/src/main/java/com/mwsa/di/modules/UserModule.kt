package com.mwsa.di.modules

import com.mwsa.domain.user.UserRepository
import com.mwsa.domain.user.usecases.GetUsersUseCase
import com.mwsa.domain.user.usecases.PostUserUseCase
import com.mwsa.infrastructure.user.UserRemoteDataSource
import com.mwsa.infrastructure.user.data.UserRepositoryImpl
import com.mwsa.infrastructure.user.data.remote.UserApi
import com.mwsa.infrastructure.user.data.remote.UserRemoteDataSourceImpl
import com.mwsa.ui.user.UserViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val userModule = module {
    factory { UserApi() }

    factory<UserRemoteDataSource> { UserRemoteDataSourceImpl(get()) }
    factory<UserRepository> { UserRepositoryImpl(get(), get()) }

    factory { GetUsersUseCase(get()) }
    factory { PostUserUseCase(get()) }

    viewModel { UserViewModel(get()) }
}
