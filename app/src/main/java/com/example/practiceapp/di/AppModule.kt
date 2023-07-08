package com.example.practiceapp.di

import android.content.Context
import androidx.room.Room
import com.example.practiceapp.data.local.TaskDao
import com.example.practiceapp.data.local.TaskDatabase
import com.example.practiceapp.data.repository.TaskRepository
import com.example.practiceapp.data.repository.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by A.Elkhami on 29/06/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext app: Context
    ): TaskDatabase {
        return Room
            .databaseBuilder(
                app, TaskDatabase::class.java, "task_db"
            )
            .build()
    }

    @Provides
    fun provideTaskDao(database: TaskDatabase): TaskDao {
        return database.taskDao()
    }

    @Provides
    fun provideTaskRepository(dao: TaskDao): TaskRepository {
        return TaskRepositoryImpl(dao)
    }
}