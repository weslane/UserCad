package com.mwsa.infrastructure.util

sealed class ResultResponse<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultResponse<T>()

    data class Error(val exception: Exception) : ResultResponse<Nothing>()
}
