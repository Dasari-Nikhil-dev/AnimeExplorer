package com.example.animeexplorer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimeDao {

    @Query("SELECT * FROM anime_summary ORDER BY score DESC")
    suspend fun getTopAnime(): List<AnimeSummaryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopAnime(list: List<AnimeSummaryEntity>)

    @Query("SELECT * FROM anime_detail WHERE malId = :id")
    suspend fun getAnimeDetail(id: Int): AnimeDetailEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeDetail(detail: AnimeDetailEntity)

}