package com.irzstudio.todoliststechoq.di

import com.irzstudio.todoliststechoq.data.Repository
import com.irzstudio.todoliststechoq.remote.RetrofitClient
import org.koin.dsl.module

val dataModule = module {
    single { RetrofitClient.instance}
    single { Repository(get()) }
}