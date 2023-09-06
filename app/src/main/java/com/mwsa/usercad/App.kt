package com.mwsa.usercad

import android.app.Application
import com.mwsa.di.appModule
import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.config.FlowManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initDBFlow()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }

    private fun initDBFlow() {

        FlowManager.init(this)
    }

}
