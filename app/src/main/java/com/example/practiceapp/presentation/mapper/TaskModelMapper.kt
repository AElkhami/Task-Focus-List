package com.example.practiceapp.presentation.mapper

import androidx.compose.ui.graphics.Color
import com.example.practiceapp.domain.model.Task
import com.example.practiceapp.presentation.home_screen.model.TaskModel

/**
 * Created by A.Elkhami on 29/06/2023.
 */

fun Task.toTaskModel():TaskModel{
    return TaskModel(
        taskName = name,
        taskType = type,
        time = "",
        isTop = isTop,
        color = Color.Black
    )
}

fun TaskModel.toTask():Task{
    return Task(
        name = taskName,
        type = taskType,
        time = "",
        isTop = isTop,
        color = 1
    )
}