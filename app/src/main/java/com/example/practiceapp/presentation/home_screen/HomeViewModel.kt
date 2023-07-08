package com.example.practiceapp.presentation.home_screen

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceapp.data.repository.TaskRepository
import com.example.practiceapp.presentation.extensions.dayOfMonth
import com.example.practiceapp.presentation.home_screen.model.DayModel
import com.example.practiceapp.presentation.home_screen.model.HomeModel
import com.example.practiceapp.presentation.home_screen.model.TaskModel
import com.example.practiceapp.presentation.mapper.toTask
import com.example.practiceapp.presentation.mapper.toTaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.util.Calendar
import javax.inject.Inject

@SuppressLint("MutableCollectionMutableState")
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    var homeUiState by mutableStateOf(HomeModel())
        private set

    init {
        generateDaysInWeekList()
        getTopTasks()
        getTasks()
    }

    @SuppressLint("SimpleDateFormat")
    fun generateDaysInWeekList() {
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
        val daysList = mutableListOf<DayModel>()
        DayOfWeek.values().zip(days) { dayNum, dayName ->
            dayName?.let {
                daysList.add(
                    DayModel(
                        dayNum = dayNum.dayOfMonth().toString(),
                        dayName = dayName,
                        isSelected = todayFormatted == dayName
                    )
                )
            }
        }

        homeUiState = homeUiState.copy(daysList = daysList)
    }

    fun insertTasks(task: TaskModel) {
        viewModelScope.launch {
            repository.insertTask(task.toTask())
            getTopTasks()
            getTasks()
        }
    }

     fun getTopTasks() {
        viewModelScope.launch {
            var topTasks: List<TaskModel> = emptyList()
            withContext(Dispatchers.IO) {
                topTasks = repository.getTopTasks().map {
                    it.toTaskModel()
                }
            }
            homeUiState = homeUiState.copy(topTasks = topTasks)
        }
    }

    fun getTasks() {
        viewModelScope.launch {
            var tasks: List<TaskModel> = emptyList()
            withContext(Dispatchers.IO) {
                tasks = repository.getTasks().map {
                    it.toTaskModel()
                }
            }
            homeUiState = homeUiState.copy(tasks = tasks)
        }
    }
}