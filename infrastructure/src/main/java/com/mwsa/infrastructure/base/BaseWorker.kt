package com.mwsa.infrastructure.base

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import org.koin.core.component.KoinComponent


abstract class BaseWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params), KoinComponent {

    override suspend fun doWork(): Result {
        return try {
            Result.success()
        } catch (ex: Exception) {
            Result.failure()
        }
    }
}
