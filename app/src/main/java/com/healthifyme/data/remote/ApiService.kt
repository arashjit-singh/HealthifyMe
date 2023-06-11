package com.healthifyme.data.remote

import com.healthifyme.data.remote.dto.SearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("cgi/search.pl?search_simple=1&json=1&action=process&fields=product_name,nutriments,image_front_thumb_url")
    suspend fun searchFood(
        @Query("search_terms") query: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
    ): SearchDto

}