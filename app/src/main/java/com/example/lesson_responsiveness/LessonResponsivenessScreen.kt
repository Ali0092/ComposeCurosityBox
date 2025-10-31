package com.example.lesson_responsiveness

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LessonResponsivenessScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(36.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .height(250.dp)
        )
        {
            Image(
                painter = painterResource(R.drawable.living_room),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.White.copy(alpha = 0.55f))
                    .align(Alignment.BottomEnd), verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(12.dp), verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Hotel California Strawberry",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    )
                    TopItemSingleTextRow(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Los Angelese, California",
                        iconColor = Color.Black.copy(alpha = 0.6f),
                        textColor = Color.Black.copy(alpha = 0.6f),
                        icon = Icons.Default.LocationOn,
                        fontSize = 15
                    )
                    TopItemSingleTextRow(
                        modifier = Modifier.fillMaxWidth(),
                        text = "4.9 (15K reviews)",
                        iconColor = Color.Yellow,
                        textColor = Color.Black.copy(alpha = 0.6f),
                        icon = Icons.Default.Star,
                        fontSize = 14
                    )

                }
                Text(
                    text = "$429/night",
                    modifier = Modifier.padding(12.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                )

            }
        }

        FlowRow(
            modifier = Modifier
                .border(1.dp, color = Color.DarkGray)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.spacedBy(
                space = 10.dp,
                alignment = Alignment.CenterHorizontally
            ),
        ) {
            dataList.forEach {
                AssistChip(
                    onClick = {},
                    label = {
                        Text(
                            text = it,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                )
            }
        }

        Text(
            "Jetpack Compose, the modern Android UI toolkit developed by Google, has revolutionized the way developers create user interfaces. With its declarative syntax and powerful components, building complex UIs has become more intuitive and efficient. One such set of components that enhance the performance of list and row views are LazyColumn and LazyRow.",
            modifier = Modifier.padding(horizontal = 24.dp),
            style = TextStyle(textAlign = TextAlign.Justify)
        )

        Text(
            "What we offer",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, textAlign = TextAlign.Center)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = 10.dp,
                alignment = Alignment.CenterHorizontally
            ),
            state = rememberLazyListState()
        ) {
            items(dataList.size) { index ->
                BottomLazyRowItem(icon = R.drawable.bed, text = "Dinner")
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            onClick = {}
        ) {
            Text(
                text = "Book Now",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }

    }
}



@Composable
fun BottomLazyRowItem(modifier: Modifier = Modifier, icon: Int, text: String) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(5.dp),
        color = Color.LightGray,
        shadowElevation = 1.dp
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                painter = painterResource(icon),
                modifier = Modifier.size(20.dp),
                contentDescription = null
            )

            Text(text)
        }
    }
}

@Composable
fun TopItemSingleTextRow(
    modifier: Modifier = Modifier,
    iconColor: Color,
    fontSize: Int,
    textColor: Color,
    text: String,
    icon: ImageVector
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = iconColor)
        Text(text = text, style = TextStyle(fontSize = (fontSize).sp), color = textColor)
    }
}

val dataList = listOf(
    "City-Center",
    "Luxury",
    "Instant Booking",
    "Exclusive Deal",
    "Early bird discount",
    "Romantic Gateway",
    "24/7 support"
)

