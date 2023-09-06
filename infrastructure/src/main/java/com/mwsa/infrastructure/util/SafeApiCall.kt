package com.mwsa.infrastructure.util

import com.mwsa.domain.util.Either

suspend inline fun <reified T> safeApiCall(
    call: suspend () -> T
): Either<Exception, T> {
    return try {
        val result: T = call()
        Either.Right(result)
    } catch (e: Exception) {
        Either.Left(e)
    }
}