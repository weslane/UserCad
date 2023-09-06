package com.mwsa.infrastructure.user.data.remote

import com.mwsa.domain.util.Either
import com.mwsa.infrastructure.base.BaseApi
import com.mwsa.infrastructure.user.model.UserApiDto

class UserApi : BaseApi(){

    suspend fun getUsers(): Either<Exception, List<UserApiDto>> =
        safeGet<List<UserApiDto>>(ENDPOINT)

    suspend fun postUser(user: UserApiDto): Either<Exception, UserApiDto> =
        safePost<UserApiDto>(ENDPOINT){
            body = user
        }

    companion object{
        private const val ENDPOINT = "Desafio/rest/desafioRest"
    }

}
