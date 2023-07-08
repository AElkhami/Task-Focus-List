package com.example.practiceapp.presentation.home_screen


import com.example.practiceapp.data.repository.TaskRepositoryImpl
import com.example.practiceapp.presentation.home_screen.model.DayModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * Created by A.Elkhami on 26/06/2023.
 */
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @Mock
    lateinit var repository: TaskRepositoryImpl

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel(repository)
    }

    @Test
    fun generateDaysInWeekList_have7DaysOfTheWeek() {
        Assert.assertEquals(7, viewModel.homeUiState.daysList.size)
    }

    @Test
    fun generateDaysInWeekList_todayIsSelected() {
        var selectedDay = DayModel()

        viewModel.homeUiState.daysList.forEach { dayModel ->
            if (dayModel.isSelected) {
                selectedDay = dayModel
            }
        }

        //Get Today's Day
        val today = Calendar.getInstance().time
        val format: DateFormat = SimpleDateFormat("EEE")
        val todayFormatted = format.format(today)

        Assert.assertEquals(todayFormatted, selectedDay.dayName)
    }
}