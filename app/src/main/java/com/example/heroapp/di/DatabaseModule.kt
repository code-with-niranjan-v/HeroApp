package com.example.heroapp.di

import android.content.Context
import androidx.room.Room
import com.example.heroapp.data.local.HeroDatabase
import com.example.heroapp.util.Constants.HERO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provide(@ApplicationContext context: Context) = Room.databaseBuilder(context,HeroDatabase::class.java,HERO_DATABASE).build()

}