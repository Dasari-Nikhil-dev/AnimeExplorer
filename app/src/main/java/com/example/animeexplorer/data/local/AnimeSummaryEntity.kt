package com.example.animeexplorer.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime_summary")
data class AnimeSummaryEntity(
    @PrimaryKey val malId: Int,
    val title: String,
    val imageUrl: String,
    val episodes: Int?,
    val score: Double?
)
