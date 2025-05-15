package com.example.healthapp.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.healthapp.domain.model.UserSetting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException

//todo

object UserSettingDataStore {
    private val Context.datastore: DataStore<UserSetting> by dataStore(
        fileName = "user_settings.pb",
        serializer = UserSettingsSerializer
    )

    suspend fun updateSettings(context: Context, update: (UserSetting) -> UserSetting) {
        context.datastore.updateData { currentSetting -> update(currentSetting) }
    }

    fun getSettings(context: Context): Flow<UserSetting> {
        return context.datastore.data.catch { exception ->
            if (exception is IOException) emit(UserSetting.getDefaultInstance())
            else throw exception
        }
    }
}
