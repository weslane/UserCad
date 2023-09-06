package com.mwsa.di.modules

import com.mwsa.infrastructure.network.netWorkClient
import org.koin.dsl.module

val networkModule = module {
    single {
        netWorkClient(Network.timeout)
    }
}

object Network{
    const val timeout = 60000L
}
