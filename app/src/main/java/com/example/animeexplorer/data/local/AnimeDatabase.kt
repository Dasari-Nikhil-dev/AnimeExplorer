package com.example.animeexplorer.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [AnimeSummaryEntity::class, AnimeDetailEntity::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {
    abstract fun AnimeDao(): AnimeDao
    companion object {
        private const val DATABASE_NAME = "anime_database"
        @Volatile
        private var INSTANCE: AnimeDatabase? = null
        fun getDatabase(context: Context): AnimeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimeDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}