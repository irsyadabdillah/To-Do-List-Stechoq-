package com.irzstudio.todoliststechoq.di

import com.irzstudio.todoliststechoq.ui.dashboard.DashboardViewModel
import com.irzstudio.todoliststechoq.ui.detail.DetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DashboardViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}