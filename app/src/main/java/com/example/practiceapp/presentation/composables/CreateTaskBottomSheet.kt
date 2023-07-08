package com.example.practiceapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceapp.presentation.home_screen.model.TaskModel
import com.example.practiceapp.presentation.ui.theme.PracticeAppTheme

/**
 * Created by A.Elkhami on 22/06/2023.
 */
@Composable
fun CreateTaskBottomSheet(
    modifier: Modifier,
    onDoneClick: (TaskModel) -> Unit,
    onCloseClick: () -> Unit
) {
    var taskTitle by remember { mutableStateOf("") }
    var taskType by remember { mutableStateOf("") }

    var selectedTaskType by remember {
        mutableStateOf("Top")
    }

    var isTopTask by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 40.dp),
        ) {
            Text(text = "Create new task", style = MaterialTheme.typography.titleLarge)
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "close sheet",
                modifier = Modifier.clickable { onCloseClick() })
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            ToggleButton(
                modifier = Modifier.padding(horizontal = 25.dp),
                currentSelection = selectedTaskType,
                buttons = listOf("Top", "normal")
            ) {
                selectedTaskType = it
                isTopTask = it == "Top"
            }
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 16.dp),
            value = taskTitle,
            onValueChange = { newText ->
                taskTitle = newText
            },
            label = {
                Text(text = "Type")
            })
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 16.dp, bottom = 16.dp),
            value = taskType,
            onValueChange = { newText ->
                taskType = newText
            },
            label = {
                Text(text = "Title")
            })
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 25.dp, end = 25.dp, top = 16.dp, bottom = 25.dp),
            onClick = {
                onDoneClick(
                    TaskModel(
                        taskName = taskTitle,
                        taskType = taskType,
                        color = Color(0xffF55C26),
                        time = "10:00 AM",
                        isTop = isTopTask
                    )
                )
            }
        ) {
            Text(text = "Done", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CreateTaskBottomSheetPreview() {
    PracticeAppTheme {
        CreateTaskBottomSheet(modifier = Modifier, onDoneClick = {

        }, onCloseClick = {

        })
    }
}