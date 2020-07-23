package com.andresaftari.submissionfinal.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.Show

@Database(entities = [Movie::class, Show::class], version = 1, exportSchema = false)
abstract class MainDB : RoomDatabase() {
    abstract fun mainDao(): MainDAO

    companion object {
        @Volatile
        private var INSTANCE: MainDB? = null

        fun getInstance(context: Context): MainDB =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MainDB::class.java,
                    "main_db"
                ).build()
            }
    }
}