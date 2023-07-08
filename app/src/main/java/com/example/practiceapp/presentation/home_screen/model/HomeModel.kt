package com.example.practiceapp.presentation.home_screen.model

/**
 * Created by A.Elkhami on 29/06/2023.
 */
data class HomeModel(
    val daysList: List<DayModel> = emptyList(),
    val topTasks: List<TaskModel> = emptyList(),
    val tasks: List<TaskModel> = emptyList()
)