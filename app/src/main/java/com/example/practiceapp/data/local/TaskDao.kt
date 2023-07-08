package com.example.practiceapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

/**
 * Created by A.Elkhami on 27/06/2023.
 */
@Dao
interface TaskDao {
    @Query("SELECT * FROM taskentity WHERE isTop = '1' ORDER BY id DESC")
    fun getTopTasks(): List<TaskEntity>

    @Query("SELECT * FROM taskentity WHERE isTop = '0' ORDER BY id DESC")
    fun getTasks(): List<TaskEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Update
    suspend fun updateTask(task: TaskEntity)

    @Delete
    suspend fun deleteTask(task: TaskEntity)
}