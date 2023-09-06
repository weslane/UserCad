package com.mwsa.domain.user.usecases

import com.mwsa.domain.user.UserRepository
import com.mwsa.domain.user.models.User

class PostUserUseCase (
    private val repository: UserRepository,
){
    suspend operator fun invoke(user: User) {
        repository.postUser(user)
    }

}
