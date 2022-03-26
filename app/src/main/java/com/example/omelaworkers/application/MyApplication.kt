package com.example.omelaworkers.application

import android.app.Application
import com.example.omelaworkers.koin.retrofitModule
import com.example.omelaworkers.koin.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(retrofitModule, viewModules))
            androidContext(this@MyApplication)
        }
    }
}