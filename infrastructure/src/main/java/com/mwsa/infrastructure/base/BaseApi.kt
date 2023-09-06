package com.mwsa.infrastructure.base

import android.util.Log
import com.mwsa.domain.util.Either
import com.mwsa.infrastructure.util.safeApiCall
import io.ktor.client.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/*
*
* BaseApi
*
* Implements HttpClient requests using Ktor framework
*
 */

abstract class BaseApi() : KoinComponent {

    val client: HttpClient by inject()
    protected val baseURL: String = API_URL

    /*
    * get *members*
    * @return *members*
     */
    suspend inline fun <reified T> get(
        endpoint: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): T {
        val result = client.get<T>(joinURL(endpoint), block)
        Log.d("Result", result.toString())
        return result
    }

    /*
    * get *members* by safeApiCall
    *
    * @return exception or *members*
     */

    suspend inline fun <reified T> safeGet(
        endpoint: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {},
    ): Either<Exception, T> = safeApiCall { get(endpoint, block) }

    suspend inline fun <reified T> safePost(
        endpoint: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {},
    ): Either<Exception, T> = safeApiCall { get(endpoint, block) }


    fun joinURL(endpoint: String) = "${checkUrl()}$endpoint"

    /*
    * Verify '/' if is the last character in baseURL
    *
    * @return baseUrl with '/' at end
    * */
    private fun checkUrl() = if (baseURL.last() == '/') baseURL else "$baseURL/"

    companion object{

        private const val API_URL =
            "https://test.avaty.com.br"
    }
}
