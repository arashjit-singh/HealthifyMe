package com.healthifyme.data

import com.healthifyme.data.local.database.FoodEntity
import com.healthifyme.domain.TrackableFood
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface FoodRepository {
    suspend fun insertFood(foodEntity: FoodEntity)
    fun getFoodPerDayForMeal(date: Date, mealType: Int): Flow<TrackableFood>
    fun getAllFoods(mealType: Int): Flow<List<TrackableFood>>
}