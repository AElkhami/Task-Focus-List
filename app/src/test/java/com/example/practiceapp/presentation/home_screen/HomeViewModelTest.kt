package com.example.practiceapp.presentation.home_screen


import com.example.practiceapp.presentation.home_screen.model.DayModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * Created by A.Elkhami on 26/06/2023.
 */
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel()
    }

    @Test
    fun generateDaysInWeekList_have7DaysOfTheWeek() {
        Assert.assertEquals(7, viewModel.weeksList.size)
    }

    @Test
    fun generateDaysInWeekList_todayIsSelected() {
        var selectedDay = DayModel()

        viewModel.weeksList.forEach { dayModel ->
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