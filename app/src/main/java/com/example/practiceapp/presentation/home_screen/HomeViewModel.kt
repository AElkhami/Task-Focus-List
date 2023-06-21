package com.example.practiceapp.presentation.home_screen

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.practiceapp.presentation.extensions.dayOfMonth
import com.example.practiceapp.presentation.home_screen.models.DayModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.Calendar

@SuppressLint("MutableCollectionMutableState")
class HomeViewModel : ViewModel() {

    val weeksList by mutableStateOf(mutableListOf<DayModel>())

    init {
        generateDaysInWeekList()
    }

    @SuppressLint("SimpleDateFormat")
    private fun generateDaysInWeekList() {
        val today = Calendar.getInstance().time
        val format: DateFormat = SimpleDateFormat("EEE")
        val todayFormatted = format.format(today)
        val calendar: Calendar = Calendar.getInstance()
        calendar.firstDayOfWeek = Calendar.MONDAY
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)

        val days = arrayOfNulls<String>(7)
        for (i in 0..6) {
            days[i] = format.format(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        DayOfWeek.values().zip(days) { dayNum, dayName ->
            dayName?.let {
                weeksList.add(
                    DayModel(
                        dayNum = dayNum.dayOfMonth().toString(),
                        dayName = dayName,
                        isSelected = todayFormatted == dayName
                    )
                )
            }
        }
    }
}