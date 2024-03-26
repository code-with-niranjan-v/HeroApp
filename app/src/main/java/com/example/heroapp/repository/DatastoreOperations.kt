package com.example.heroapp.repository

import kotlinx.coroutines.flow.Flow


interface DatastoreOperations {

    suspend fun saveOnBoardingState(isCompleted:Boolean)
    fun readOnBoardingState(): Flow<Boolean>

}