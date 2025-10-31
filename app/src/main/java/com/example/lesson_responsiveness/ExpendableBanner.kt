package com.example.lesson_responsiveness

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TempPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExpendableBanner()
    }
}

@Composable
fun ExpendableBanner(modifier: Modifier = Modifier) {

    var canExpand by remember { mutableStateOf(false) }
    var icon by remember { mutableStateOf(Icons.Filled.KeyboardArrowDown) }
    var textData by remember { mutableStateOf(R.string.short_description) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp),
        color = Color(0xFFFF5722),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            )
            {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )

                Text(
                    text = "Project X",
                    color = Color.White,
                    style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Medium),
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            canExpand = !canExpand
                            icon =
                                if (canExpand) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
                            textData =
                                if (canExpand) R.string.long_description else R.string.short_description
                        }
                )
            }

            Text(
                text = stringResource(textData)             ,
                color = Color.White,
                modifier = Modifier.padding(start = 36.dp)
            )
            Text(
                text = "NOV 23, 2025",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 36.dp)
                    .align(Alignment.End)
            )
        }
    }

}