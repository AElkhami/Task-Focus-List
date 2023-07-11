package com.example.practiceapp.di

import androidx.room.Room
import com.example.practiceapp.data.local.TaskDatabase
import com.example.practiceapp.data.repository.TaskRepository
import com.example.practiceapp.data.repository.TaskRepositoryImpl
import com.example.practiceapp.presentation.home_screen.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by A.Elkhami on 10/07/2023.
 */

val appModule = module {
    single {
        Room
            .databaseBuilder(
                androidContext(), TaskDatabase::class.java, "task_db"
            )
            .build()
    }
    single {
        get<TaskDatabase>().taskDao()
    }
    single<TaskRepository> {
        TaskRepositoryImpl(get())
    }
    viewModel { HomeViewModel(get()) }
}