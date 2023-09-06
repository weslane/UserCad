package com.mwsa.domain.user.usecases

import com.mwsa.domain.user.UserRepository
import com.mwsa.domain.user.models.User

class GetUsersUseCase(
    private val repostory: UserRepository,
) {

    suspend operator fun invoke(): List<User> =
        repostory.getUsers()

}
