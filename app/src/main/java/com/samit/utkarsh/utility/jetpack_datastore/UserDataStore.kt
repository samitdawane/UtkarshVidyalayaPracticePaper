package com.samit.utkarsh.utility.jetpack_datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserDataStore(
    context: Context
) {
    private val applicationContext = context.applicationContext
    private val dataStore: DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(
            name = "app_preferences"
        )
    }

    val isLogin: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_IS_LOGIN]
        }

    suspend fun setIsLogin(isLogin: String) {
        dataStore.edit { preferences ->
            preferences[KEY_IS_LOGIN] = isLogin
        }
    }

    val userId: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_USER_ID]
        }

    suspend fun setUserId(passCode: String) {
        dataStore.edit { preferences ->
            preferences[KEY_USER_ID] = passCode
        }
    }
    val name: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_NAME]
        }

    suspend fun setName(name: String) {
        dataStore.edit { preferences ->
            preferences[KEY_NAME] = name
        }
    }


    companion object {
        val KEY_IS_LOGIN = preferencesKey<String>("key_is_login")
        val KEY_USER_ID = preferencesKey<String>("key_user_id")
        val KEY_NAME = preferencesKey<String>("key_name")

    }
}