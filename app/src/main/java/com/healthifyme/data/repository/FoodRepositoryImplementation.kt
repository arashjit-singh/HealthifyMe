package com.healthifyme.data.repository

import com.healthifyme.data.FoodRepository
import com.healthifyme.data.local.database.FoodDatabase
import com.healthifyme.data.local.database.FoodEntity
import com.healthifyme.data.mapper.toTrackableFood
import com.healthifyme.domain.TrackableFood
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.util.Date
import javax.inject.Inject

class FoodRepositoryImplementation @Inject constructor(
    private val foodDatabase: FoodDatabase,
    val dispatcher: CoroutineDispatcher
) : FoodRepository {
    override suspend fun insertFood(foodEntity: FoodEntity) {
        withContext(dispatcher) {
            foodDatabase.provideFoodDao().insertFood(foodEntity)
        }
    }

    override fun getFoodPerDayForMeal(date: Date, mealType: Int): Flow<TrackableFood> {
        return flow {
            val foodList = withContext(dispatcher) {
                foodDatabase.provideFoodDao().getFoodPerDay(date = date, mealType = mealType)
            }
            foodList.map {
                it.toTrackableFood()
            }
        }
    }

    override fun getAllFoods(mealType: Int): Flow<List<TrackableFood>> {
        return flow {
            val foods = withContext(dispatcher) {
                foodDatabase.provideFoodDao().getFoodFromDb()
            }

            emit(foods.map { it ->
                it.toTrackableFood()
            })
        }
    }
}