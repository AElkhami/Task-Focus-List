package com.example.practiceapp.data.repository

import com.example.practiceapp.data.local.TaskDao
import com.example.practiceapp.domain.mappers.toTask
import com.example.practiceapp.domain.mappers.toTaskEntity
import com.example.practiceapp.domain.model.Task

/**
 * Created by A.Elkhami on 27/06/2023.
 */
open class TaskRepositoryImpl constructor(private val dao: TaskDao) : TaskRepository {
    override suspend fun getTopTasks(): List<Task> {
        return dao.getTopTasks().map {
            it.toTask()
        }
    }

    override suspend fun getTasks(): List<Task> {
        return dao.getTasks().map {
            it.toTask()
        }
    }

    override suspend fun insertTask(task: Task) {
        dao.insertTask(task.toTaskEntity())
    }

    override suspend fun updateTask(task: Task) {
        dao.updateTask(task.toTaskEntity())
    }

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(task.toTaskEntity())
    }
}