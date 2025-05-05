package com.example.healthapp.di

import android.content.Context
import com.example.healthapp.domain.model.UserSetting
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideUserSettingsDataStore(@ApplicationContext context: Context): DataStore<UserSetting> {
        return context.dataStore
    }

}