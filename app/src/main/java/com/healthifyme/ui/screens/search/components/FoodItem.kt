package com.healthifyme.ui.screens.search.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.healthifyme.domain.TrackableFood

@Composable
fun FoodItem(item: TrackableFood, onItemClick: () -> Unit, modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .border(width = 0.25.dp, shape = RoundedCornerShape(5.dp), color = Color.LightGray)
            .clickable {
                onItemClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(
                item.imageUrl
            ).build(),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(75.dp)
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
                .padding(start = 20.dp),
        ) {
            Row(modifier = Modifier.padding(bottom = 10.dp)) {
                Text(
                    text = item.productName, modifier = Modifier
                        .weight(1.0f)
                        .fillMaxWidth(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(
                        text = "${item.caloriesPer100g} g",
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "${item.proteinPer100g} g",
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "${item.fatPer100g} g",
                        textAlign = TextAlign.Center
                    )
                }
            }
            Row() {
                Text(
                    text = "${item.caloriesPer100g}kcal/100g", modifier = Modifier
                        .weight(1.0f)
                        .fillMaxWidth()
                )
                Text(
                    text = "Carbs",
                    modifier = Modifier.defaultMinSize(minWidth = 40.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Protein",
                    modifier = Modifier.defaultMinSize(minWidth = 40.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Fat",
                    modifier = Modifier.defaultMinSize(minWidth = 40.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}
