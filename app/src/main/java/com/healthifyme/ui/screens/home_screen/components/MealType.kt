package com.healthifyme.ui.screens.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.healthifyme.R

@Composable
fun MealType(
    mealType: String,
    mealImg: Int,
    contentDescription: String,
    showAddMealView: Boolean,
    onRowClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier
            .clickable {
                onRowClick()
            }
            .padding(10.dp)) {
            Image(
                painter = painterResource(id = mealImg),
                contentDescription = contentDescription,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Row() {
                    Text(text = mealType, fontSize = 22.sp, modifier = Modifier.weight(1.0f))
                    Image(
                        painter = if (!showAddMealView)
                            painterResource(id = R.drawable.baseline_arrow_drop_down_24)
                        else
                            painterResource(id = R.drawable.baseline_arrow_drop_up_24),
                        contentDescription = "Add ${mealType}"
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Row(
                        verticalAlignment = Alignment.Bottom, modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "0",
                            fontSize = 22.sp,
                        )
                        Text(
                            text = " Kcal",
                            fontSize = 16.sp,
                        )
                    }
                    Row(modifier = Modifier.weight(2f)) {
                        CalorieCounter()
                    }

                }
            }
        }
        if (showAddMealView) {
            Column() {
                Text(
                    text = "+ Add ${mealType}",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape(25.dp)
                        )
                        .clipToBounds()
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = Color.Green,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    MealType("Lunch", R.drawable.ic_lunch, "Food", true, {})
}