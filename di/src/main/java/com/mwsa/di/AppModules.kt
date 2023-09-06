package com.mwsa.di

import com.mwsa.di.modules.networkModule
import com.mwsa.di.modules.userModule

val appModule = listOf(
    networkModule,
    userModule,
)
