package com.irzstudio.todoliststechoq

import android.app.Application
import android.content.Context
import com.irzstudio.todoliststechoq.di.dataModule
import com.irzstudio.todoliststechoq.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.time.chrono.HijrahChronology.INSTANCE

class AppController : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppController)
            modules(dataModule)
            modules(viewModelModule)
        }

    }

}