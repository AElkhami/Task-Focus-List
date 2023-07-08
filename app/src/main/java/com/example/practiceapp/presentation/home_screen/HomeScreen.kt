package com.example.practiceapp.presentation.home_screen

import android.annotation.SuppressLint
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
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.practiceapp.presentation.composables.CalendarDayItem
import com.example.practiceapp.presentation.composables.CreateTaskBottomSheet
import com.example.practiceapp.presentation.composables.TaskItem
import com.example.practiceapp.presentation.composables.TopTaskItem
import com.example.practiceapp.presentation.home_screen.model.DayModel
import com.example.practiceapp.presentation.home_screen.model.TaskModel
import com.example.practiceapp.presentation.ui.theme.MainTeal
import com.example.practiceapp.presentation.ui.theme.PracticeAppTheme
import kotlinx.coroutines.launch

lateinit var selectedDay: DayModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val sheetState =
        rememberStandardBottomSheetState(initialValue = SheetValue.Hidden, skipHiddenState = false)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            CreateTaskBottomSheet(modifier = Modifier, onCloseClick = {
                coroutineScope.launch {
                    sheetState.hide()
                }
            }, onDoneClick = { taskModel ->
                coroutineScope.launch {
                    sheetState.hide()
                }
                viewModel.insertTasks(taskModel)
            })
        },
        sheetSwipeEnabled = false,
        sheetDragHandle = null,
    ) {
        Scaffold(
            modifier = modifier,
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    coroutineScope.launch {
                        sheetState.expand()
                    }
                }) {
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
                DaysSection(viewModel.homeUiState.daysList)
                Text(
                    text = "High pariority tasks",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
                )
                TopTasksSection(viewModel.homeUiState.topTasks)
                Text(
                    text = "Tasks",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
                )
                NormalTasksSection(viewModel.homeUiState.tasks)
            }
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

@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DaysSection(weeksList: List<DayModel>) {

    var currentWeek by remember { mutableStateOf(weeksList) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 16.dp)
            .semantics { testTagsAsResourceId = true }
            .testTag("DaysList"),
    ) {
        items(currentWeek.size) { index ->
            CalendarDayItem(
                modifier = Modifier
                    .width(77.dp)
                    .height(90.dp)
                    .padding(8.dp),
                currentWeek[index],
            ) { dayItem ->
                currentWeek = currentWeek.mapIndexed { selectedIndex, dayModel ->
                    if (index == selectedIndex) {
                        if (dayModel.isSelected) {
                            dayModel.copy(isSelected = true)
                        } else {
                            dayModel.copy(isSelected = true)
                        }
                    } else {
                        dayModel.copy(isSelected = false)
                    }
                } as MutableList<DayModel>
                selectedDay = dayItem
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TopTasksSection(topTasksList: List<TaskModel>) {
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
fun NormalTasksSection(tasksList: List<TaskModel>) {
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