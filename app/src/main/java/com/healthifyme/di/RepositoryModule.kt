package com.healthifyme.di

import com.healthifyme.data.FoodRepository
import com.healthifyme.data.local.database.FoodDatabase
import com.healthifyme.data.remote.ApiService
import com.healthifyme.data.remote.SearchRepositoryInterface
import com.healthifyme.data.remote.repository.SearchRepository
import com.healthifyme.data.repository.FoodRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSearchRepository(api: ApiService): SearchRepositoryInterface {
        return SearchRepository(api)
    }

    @Provides
    @Singleton
    fun provideFoodRepository(
        foodDatabase: FoodDatabase,
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
    ): FoodRepository {
        return FoodRepositoryImplementation(foodDatabase, defaultDispatcher)
    }
}