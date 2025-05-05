package com.example.healthapp.di

import android.content.Context
import com.example.healthapp.data.local.database.HealthAppDatabase
import com.example.healthapp.data.local.database.dao.SleepDao
import com.example.healthapp.data.local.database.dao.StepDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): HealthAppDatabase {
        return HealthAppDatabase.getDatabase(context)
    }

    @Provides
    fun provideStepDao(database: HealthAppDatabase): StepDao = database.stepDao()

    @Provides
    fun provideSleepDao(database: HealthAppDatabase): SleepDao = database.sleepDao()
}