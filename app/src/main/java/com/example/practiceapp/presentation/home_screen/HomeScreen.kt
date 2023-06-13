package com.example.practiceapp.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceapp.presentation.composables.CalendarDayItem
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

@Composable
fun HomeScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFDCE3EC))
    ) {
        DaysSection(modifier = Modifier)
    }
}

@Composable
fun DaysSection(modifier: Modifier) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 26.dp),
    ) {
        items(daysList) { dayItem ->
            CalendarDayItem(
                modifier = modifier
                    .width(77.dp)
                    .height(90.dp)
                    .padding(8.dp),
                dayItem
            )
        }
    }
}

@Composable
fun TopTasksSection(modifier: Modifier) {

}

@Composable
fun NormalTasksSection(modifier: Modifier) {

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PracticeAppTheme {
        HomeScreen(modifier = Modifier)
    }
}