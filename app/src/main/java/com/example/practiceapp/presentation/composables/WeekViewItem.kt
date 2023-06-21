package com.example.practiceapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceapp.presentation.home_screen.models.DayModel
import com.example.practiceapp.presentation.ui.theme.PracticeAppTheme

@Composable
fun CalendarDayItem(
    modifier: Modifier,
    dayItem: DayModel,
    onClick: (DayModel) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = if (dayItem.isSelected) Color(0xFFB3DDE3) else Color(0xFFF3F3F6)
            )
            .clickable {
                onClick(dayItem)
            }
            .padding(8.dp)
    ) {
        Text(
            text = dayItem.dayNum,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(
            text = dayItem.dayName,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarDayItemPreview() {
    PracticeAppTheme {
        CalendarDayItem(modifier = Modifier, DayModel("8", "Mon")) {}
    }
}