package com.mwsa.infrastructure.util

import androidx.work.Data
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.BackoffPolicy
import java.util.concurrent.TimeUnit

fun getNetworkConstraints(): Constraints =
    Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()

inline fun <reified T : ListenableWorker> setOneTimeNetworkRequest(data: Data? = null): OneTimeWorkRequest {
    return OneTimeWorkRequestBuilder<T>()
        .apply { data?.let { setInputData(data) } }
        .setConstraints(getNetworkConstraints())
        .setBackoffCriteria(
            BackoffPolicy.LINEAR,
            30L,
            TimeUnit.SECONDS
        )
        .build()
}