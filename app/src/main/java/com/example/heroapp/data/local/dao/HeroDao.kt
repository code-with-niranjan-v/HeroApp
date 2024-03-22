package com.example.heroapp.data.local.dao

//import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.heroapp.domain.model.Hero

@Dao
interface HeroDao {

//    @Query("select * from hero_table order by id asc")
//    fun getAllHero():PagingSource<Int,Hero>

    @Query("select * from hero_table where id = :heroId")
    fun getSelectedHero(heroId:Int):Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHeroes(heroes: List<Hero>)

    @Query("delete from hero_table")
    fun deleteHeroes()
}