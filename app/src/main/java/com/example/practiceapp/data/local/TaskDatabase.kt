package com.example.practiceapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by A.Elkhami on 27/06/2023.
 */
@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}