package com.healthifyme.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.healthifyme.data.local.DefaultSharedPreferences
import com.healthifyme.data.local.SharedPreferencesInterface
import com.healthifyme.data.local.database.FoodDao
import com.healthifyme.data.local.database.FoodDatabase
import com.healthifyme.util.Constants
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

    @Provides
    @Singleton
    fun provideFoodDatabase(@ApplicationContext context: Context): FoodDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = FoodDatabase::class.java,
            name = Constants.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideFoodDao(database: FoodDatabase): FoodDao {
        return database.provideFoodDao()
    }

}