package com.healthifyme.data.remote

import com.healthifyme.domain.TrackableFood

interface SearchRepositoryInterface {
    suspend fun searchFood(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<TrackableFood>>
}