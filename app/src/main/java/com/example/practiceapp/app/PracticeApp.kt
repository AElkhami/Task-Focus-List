package com.example.practiceapp.app

import android.app.Application
import com.example.practiceapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by A.Elkhami on 29/06/2023.
 */
class PracticeApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@PracticeApp)
            modules(appModule)
        }
    }
}
