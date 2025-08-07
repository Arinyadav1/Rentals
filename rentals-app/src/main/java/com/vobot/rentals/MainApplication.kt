package com.vobot.rentals

import android.app.Application
import com.vobot.rentals.core.data.di.repositoryModule
import com.vobot.rentals.feature.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(repositoryModule, homeModule)
        }
    }
}
