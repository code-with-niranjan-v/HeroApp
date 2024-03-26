package com.example.heroapp.di

import android.content.Context
import com.example.heroapp.data.pref.DatastoreOperationImplementation
import com.example.heroapp.repository.DatastoreOperations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDatastoreOperations(@ApplicationContext app:Context):DatastoreOperations = DatastoreOperationImplementation(app)

}