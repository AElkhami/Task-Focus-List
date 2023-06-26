package com.example.practiceapp.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceapp.presentation.ui.theme.PracticeAppTheme

/**
 * Created by A.Elkhami on 22/06/2023.
 */
@Composable
fun ToggleButton(
    modifier: Modifier,
    currentSelection: String,
    buttons: List<String>,
    onButtonClick: (String) -> Unit
) {
    val selectedTint = MaterialTheme.colorScheme.primary
    val unselectedTint = Color.Unspecified

    Row(
        modifier = modifier.border(
            border = BorderStroke(1.dp, Color.Gray),
            shape = RoundedCornerShape(32.dp)
        )
    ) {
        buttons.forEachIndexed { index, text ->
            val isSelected = currentSelection == text
            val backgroundTint = if (isSelected) selectedTint else unselectedTint
            val textColor = if (isSelected) Color.White else Color.Unspecified

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(80.dp)
                    .clip(
                        if (index == 0) {
                            RoundedCornerShape(topStart = 32.dp, bottomStart = 32.dp)
                        } else {
                            RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp)
                        }
                    )
                    .toggleable(value = isSelected, enabled = true, onValueChange = { selected ->
                        if (selected) {
                            onButtonClick(text)
                        }
                    }
                    )
                    .background(backgroundTint)
                    .padding(vertical = 4.dp, horizontal = 4.dp),
            ) {
                Text(
                    text = text,
                    color = textColor,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ToggleButtonPreview() {
    PracticeAppTheme {
        ToggleButton(
            modifier = Modifier, "Top", listOf("Top", "normal")
        ) {

        }
    }
}