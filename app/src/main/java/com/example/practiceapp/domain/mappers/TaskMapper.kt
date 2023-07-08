package com.example.practiceapp.domain.mappers

import com.example.practiceapp.data.local.TaskEntity
import com.example.practiceapp.domain.model.Task

/**
 * Created by A.Elkhami on 27/06/2023.
 */

fun Task.toTaskEntity() = TaskEntity(
    name = this.name,
    type = this.type,
    color = this.color,
    time = this.time,
    isTop = this.isTop
)

fun TaskEntity.toTask() = Task(
    name = this.name,
    type = this.type,
    color = this.color,
    time = this.time,
    isTop = this.isTop
)