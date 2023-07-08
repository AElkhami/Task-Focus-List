package com.example.practiceapp.data.repository

import com.example.practiceapp.domain.model.Task

/**
 * Created by A.Elkhami on 27/06/2023.
 */
interface TaskRepository {
    suspend fun getTopTasks(): List<Task>

    suspend fun getTasks(): List<Task>

    suspend fun insertTask(task: Task)

    suspend fun updateTask(task: Task)

    suspend fun deleteTask(task: Task)
}