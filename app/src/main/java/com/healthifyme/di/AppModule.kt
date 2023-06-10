package com.healthifyme.di

import android.content.Context
import android.content.SharedPreferences
import com.healthifyme.data.local.DefaultSharedPreferences
import com.healthifyme.data.local.SharedPreferencesInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideDefaultSharedPreferences(sharedPreferences: SharedPreferences): SharedPreferencesInterface {
        return DefaultSharedPreferences(sharedPreferences)
    }

}