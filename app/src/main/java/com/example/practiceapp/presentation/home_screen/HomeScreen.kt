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
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

val daysList = listOf(
    DayModel("1", "Mon"),
    DayModel("2", "Tue"),
    DayModel("3", "Wed"),
    DayModel("4", "Thu"),
    DayModel("5", "Fri"),
    DayModel("6", "Sat"),
    DayModel("7", "Sun"),
)

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

@Composable
fun HomeScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFDCE3EC))
    ) {
        TopSection()
        DaysSection()
        Text(
            text = "High pariority tasks",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
        TopTasksSection()
        Text(
            text = "Tasks",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
        NormalTasksSection()
    }
}

@Composable
fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
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
                    contentDescription = "Profile",
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

@Composable
fun DaysSection() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 16.dp),
    ) {
        items(daysList) { dayItem ->
            CalendarDayItem(
                modifier = Modifier
                    .width(77.dp)
                    .height(90.dp)
                    .padding(8.dp),
                dayItem
            )
        }
    }
}

@Composable
fun TopTasksSection() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp)
    ) {
        items(topTasksList) { task ->
            TopTaskItem(modifier = Modifier, task)
        }
    }
}

@Composable
fun NormalTasksSection() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp)
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