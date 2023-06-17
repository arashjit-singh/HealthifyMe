package com.healthifyme.ui.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.healthifyme.ui.screens.home_screen.components.MealType
import com.healthifyme.R

@Composable
fun HomeScreen() {

    var showAddBreakfastView by remember {
        mutableStateOf(false)
    }
    var showAddLunchView by remember {
        mutableStateOf(false)
    }
    var showAddDinnerView by remember {
        mutableStateOf(false)
    }
    var showAddSnacksView by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        MealType("Breakfast", R.drawable.ic_breakfast, "Food", showAddBreakfastView, {
            showAddBreakfastView = !showAddBreakfastView
        })
        MealType("Lunch", R.drawable.ic_lunch, "Food", showAddLunchView, {
            showAddLunchView = !showAddLunchView
        })
        MealType("Dinner", R.drawable.ic_dinner, "Food", showAddDinnerView, {
            showAddDinnerView = !showAddDinnerView
        })
        MealType("Snacks", R.drawable.ic_snack, "Food", showAddSnacksView, {
            showAddSnacksView = !showAddSnacksView
        })
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}