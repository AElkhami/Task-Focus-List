package com.example.practiceapp.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practiceapp.presentation.composables.CalendarDayItem
import com.example.practiceapp.presentation.composables.TaskItem
import com.example.practiceapp.presentation.composables.TopTaskItem
import com.example.practiceapp.presentation.home_screen.models.DayModel
import com.example.practiceapp.presentation.home_screen.models.TaskModel
import com.example.practiceapp.presentation.home_screen.models.TopTaskModel
import com.example.practiceapp.presentation.ui.theme.MainTeal
import com.example.practiceapp.presentation.ui.theme.PracticeAppTheme


val topTasksList = listOf(
    TopTaskModel(type = "Meeting", name = "Amanda at Ruth's", time = "10:00 AM"),
    TopTaskModel(type = "Meeting", name = "Hey Hey Hey", time = "12:00 PM"),
    TopTaskModel(type = "Meeting", name = "Amanda at Ruth's", time = "10:00 AM"),
    TopTaskModel(type = "Meeting", name = "Hey Hey Hey", time = "12:00 PM")
)

val tasksList = listOf(
    TaskModel(taskName = "General", taskType = "16 Tasks", color = Color(0xff3068DF)),
    TaskModel(taskName = "Meetings", taskType = "8 Tasks", color = Color(0xffF55C26)),
    TaskModel(taskName = "General", taskType = "16 Tasks", color = Color(0xff3068DF)),
    TaskModel(taskName = "Meetings", taskType = "8 Tasks", color = Color(0xffF55C26))
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier) {
    Scaffold(modifier = modifier, floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    },
        floatingActionButtonPosition = FabPosition.End,

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color(0xFFDCE3EC))
        ) {
            TopSection()
            DaysSection()
            Text(
                text = "High pariority tasks",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )
            TopTasksSection()
            Text(
                text = "Tasks",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )
            NormalTasksSection()
        }
    }

}

@Composable
fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
            .background(MainTeal)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    Icons.Outlined.Person,
                    tint = Color.White,
                    contentDescription = "Profile",
                    modifier = Modifier.padding(16.dp)
                )
                Icon(
                    Icons.Outlined.Notifications,
                    tint = Color.White,
                    contentDescription = "Notification",
                    modifier = Modifier.padding(16.dp)
                )
            }
            Text(
                text = "Good Morning",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 32.sp,
                modifier = Modifier.padding(16.dp),
                color = Color.White
            )

            Text(
                text = "0 out of 10 tasks today.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DaysSection() {
    var daysList by remember {
        mutableStateOf(
            listOf(
                DayModel("1", "Mon"),
                DayModel("2", "Tue"),
                DayModel("3", "Wed"),
                DayModel("4", "Thu"),
                DayModel("5", "Fri"),
                DayModel("6", "Sat"),
                DayModel("7", "Sun"),
            )
        )
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 16.dp)
            .semantics { testTagsAsResourceId = true }
            .testTag("DaysList"),
    ) {
        items(daysList.size) { index ->
            CalendarDayItem(
                modifier = Modifier
                    .width(77.dp)
                    .height(90.dp)
                    .padding(8.dp),
                daysList[index]
            ) {
                daysList = daysList.mapIndexed { selectedIndex, dayModel ->
                    if (index == selectedIndex) {
                        dayModel.copy(isSelected = !dayModel.isSelected)
                    } else {
                        dayModel.copy(isSelected = false)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TopTasksSection() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp)
            .semantics { testTagsAsResourceId = true }
            .testTag("TopTasksList")
    ) {
        items(topTasksList) { task ->
            TopTaskItem(modifier = Modifier, task)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NormalTasksSection() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp)
            .semantics { testTagsAsResourceId = true }
            .testTag("TasksList")
    ) {
        items(tasksList) { task ->
            TaskItem(modifier = Modifier, task)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PracticeAppTheme {
        HomeScreen(modifier = Modifier)
    }
}