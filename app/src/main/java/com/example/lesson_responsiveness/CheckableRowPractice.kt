package com.example.lesson_responsiveness

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson_responsiveness.viewmodel.CuriosityBoxViewModel

data class Todo(
    val title: String = "Bring out trash",
    val description: String = "Better do this before wife comes home.",
    val isChecked: Boolean = false
)

@Composable
fun CheckableRowPractice(modifier: Modifier = Modifier) {
    val viewModel = viewModel<CuriosityBoxViewModel>()
    val checkListState by viewModel.checkListItem.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFABABAB))
    ) {
        CheckableRowItem(dataItem = checkListState, onCheckChanged = {
            viewModel.setValueToUnChecked()
        })
    }
}

@Composable
fun CheckableRowItem(modifier: Modifier = Modifier, dataItem: Todo, onCheckChanged: (Boolean) -> Unit) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        shape = RoundedCornerShape(12.dp),
        color = Color.White
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(text = dataItem.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        textDecoration = if (dataItem.isChecked) TextDecoration.LineThrough else TextDecoration.None,
                        fontWeight = FontWeight.Black
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(text = dataItem.description,
                    style = MaterialTheme.typography.titleSmall.copy(
                        textDecoration = if (dataItem.isChecked) TextDecoration.LineThrough else TextDecoration.None,
                        fontWeight = FontWeight.Normal
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Checkbox(
                checked = dataItem.isChecked,
                onCheckedChange = { value ->
                    onCheckChanged(value)
                }
            )
        }
    }
}