package com.example.practiceapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by A.Elkhami on 27/06/2023.
 */
@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: String,
    val color: Int,
    val time: String,
    val isTop: Boolean
)