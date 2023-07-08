package com.example.practiceapp.domain.model

/**
 * Created by A.Elkhami on 27/06/2023.
 */
data class Task(
    val name: String,
    val type: String,
    val color: Int,
    val time: String,
    val isTop: Boolean
)
