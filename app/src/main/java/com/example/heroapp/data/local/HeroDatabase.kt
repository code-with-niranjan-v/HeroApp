package com.example.heroapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.heroapp.data.local.dao.HeroDao
import com.example.heroapp.domain.model.Hero
import com.example.heroapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class,HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class HeroDatabase :RoomDatabase(){

    abstract fun getDao():HeroDao
    abstract fun getRemoteKeyDao():HeroRemoteKey
}