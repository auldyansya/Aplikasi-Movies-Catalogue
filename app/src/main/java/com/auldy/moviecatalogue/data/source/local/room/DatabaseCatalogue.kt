package com.auldy.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
@Database(
    entities = [MoviesEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false
)

abstract class DatabaseCatalogue : RoomDatabase() {
    abstract fun Dao(): Dao

    companion object {

        @Volatile
        private var INSTANCE: DatabaseCatalogue? = null

        fun getInstance(context: Context): DatabaseCatalogue =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseCatalogue::class.java,
                    "MovieCatalogue.db"
                ).build().apply {
                    INSTANCE = this
                }
            }

    }
}