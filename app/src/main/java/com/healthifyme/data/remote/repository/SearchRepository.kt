package com.healthifyme.data.remote.repository

import com.healthifyme.data.remote.ApiService
import com.healthifyme.data.remote.SearchRepositoryInterface
import com.healthifyme.data.remote.mapper.toTrackableFood
import com.healthifyme.domain.TrackableFood
import javax.inject.Inject

class SearchRepository @Inject constructor(val api: ApiService) : SearchRepositoryInterface {
    override suspend fun searchFood(
        query: String, page: Int, pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val res = api.searchFood(
                query = query, page = page, pageSize = pageSize
            )
            val trackableList = res.products.map { it.toTrackableFood() }
            Result.success(trackableList)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}