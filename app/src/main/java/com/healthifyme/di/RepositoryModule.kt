package com.healthifyme.di

import com.healthifyme.data.remote.ApiService
import com.healthifyme.data.remote.SearchRepositoryInterface
import com.healthifyme.data.remote.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSearchRepository(api: ApiService): SearchRepositoryInterface {
        return SearchRepository(api)
    }
}