package com.example.practiceapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.practiceapp.presentation.home_screen.models.TopTaskModel
import com.example.practiceapp.presentation.ui.theme.PracticeAppTheme

@Composable
fun TopTaskItem(modifier: Modifier, task: TopTaskModel) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(10.dp)
                .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                .background(Color(0xffF55C26))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .width(180.dp)
                .clip(RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = task.type,
                color = Color(0xffF55C26),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = task.name, style = MaterialTheme.typography.titleMedium)
            Text(text = task.time, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 1)
@Composable
fun TopTaskItemPreview() {
    PracticeAppTheme {
        TopTaskItem(
            modifier = Modifier,
            task = TopTaskModel(type = "Meeting", name = "Amanda at Ruth's", time = "10:00 AM")
        )
    }
}
