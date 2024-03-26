package com.example.heroapp.data.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.preferencesDataStore
import com.example.heroapp.repository.DatastoreOperations
import com.example.heroapp.util.Constants.HERO_DATASTORE_KEY
import com.example.heroapp.util.Constants.HERO_DATASTORE_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.datastore:DataStore<Preferences> by preferencesDataStore(name = HERO_DATASTORE_NAME)
class DatastoreOperationImplementation(context: Context):DatastoreOperations {

    private object PreferencesKey{
        val onBoardingKey = booleanPreferencesKey(name = HERO_DATASTORE_KEY)
    }

    private val datastore = context.datastore
    override fun readOnBoardingState(): Flow<Boolean> {
        return datastore.data
            .catch { exception->
                if (exception is IOException){
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }
            .map {preferences->
                val onBoardingState = preferences[PreferencesKey.onBoardingKey]?:false
                onBoardingState
            }
    }

    override suspend fun saveOnBoardingState(isCompleted: Boolean) {
        datastore.edit { preferences->
            preferences[PreferencesKey.onBoardingKey] = isCompleted
        }
    }
}