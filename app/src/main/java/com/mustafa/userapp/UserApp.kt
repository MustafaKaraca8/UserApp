package com.mustafa.userapp

import android.app.Application
import com.mustafa.userapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class UserApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@UserApp)
            androidLogger()

            modules(appModule)
        }
    }
}