package com.example.practiceapp.presentation.extensions

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

fun DayOfWeek.dayOfMonth(dateInWeek: LocalDate = LocalDate.now()): Int {
    val firstDateOfWeek = dateInWeek.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
    val dateOfDayOfWeek = firstDateOfWeek.with(TemporalAdjusters.nextOrSame(this))
    return dateOfDayOfWeek.dayOfMonth
}