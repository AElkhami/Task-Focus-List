package com.example.practiceapp.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.practiceapp.R

val appFont = FontFamily(
    Font(R.font.rajdhani_bold, FontWeight.Bold),
    Font(R.font.rajdhani_light, FontWeight.Light),
    Font(R.font.rajdhani_medium, FontWeight.Medium),
    Font(R.font.rajdhani_regular, FontWeight.Normal),
    Font(R.font.rajdhani_semi_bold, FontWeight.SemiBold)
)

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 21.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
    )
)
