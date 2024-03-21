package com.example.heroapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.heroapp.domain.model.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

    @Query("select * from hero_remote_key_table where id = :id")
    fun getRemoteKey(id:Int):HeroRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRemoteKeys(remoteKeys:List<HeroRemoteKey>)

    @Query("delete from hero_remote_key_table")
    fun deleteRemoteKeys()

}