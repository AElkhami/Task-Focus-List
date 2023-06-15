package com.example.practiceapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceapp.presentation.home_screen.models.TaskModel
import com.example.practiceapp.presentation.ui.theme.PracticeAppTheme

@Composable
fun TaskItem(modifier: Modifier, task: TaskModel) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(90.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {
        Box(
            modifier = modifier
                .width(10.dp)
                .height(80.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(task.color)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = task.taskName, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = task.taskType, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun TaskItemPreview() {
    PracticeAppTheme {
        TaskItem(
            modifier = Modifier,
            task = TaskModel("Workout", "Training", Color(0xff3068DF))
        )
    }
}