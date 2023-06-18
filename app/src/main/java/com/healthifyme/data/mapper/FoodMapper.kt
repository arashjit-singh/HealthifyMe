package com.healthifyme.data.mapper

import com.healthifyme.data.local.database.FoodEntity
import com.healthifyme.domain.TrackableFood
import java.util.Date

fun FoodEntity.toTrackableFood(): TrackableFood {
    return TrackableFood(
        productName = productName,
        imageUrl = productImage,
        caloriesPer100g = calories,
        carbsPer100g = carbs,
        proteinPer100g = protein,
        fatPer100g = fat
    )
}

fun TrackableFood.toFoodEntity(mealType: Int, quantity: Int): FoodEntity {
    return FoodEntity(
        mealId = mealType,
        calories = caloriesPer100g,
        carbs = carbsPer100g,
        protein = proteinPer100g,
        fat = fatPer100g,
        productName = productName,
        productImage = imageUrl,
        mealDate = Date(System.currentTimeMillis()),
        quantity = quantity
    )
}