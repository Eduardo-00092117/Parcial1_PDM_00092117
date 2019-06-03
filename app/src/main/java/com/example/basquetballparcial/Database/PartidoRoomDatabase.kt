package com.example.basquetballparcial.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basquetballparcial.Database.Dao.partidoDao
import com.example.basquetballparcial.Database.Entities.partido

@Database(entities = [partido::class], version = 2, exportSchema = false)
abstract class PartidoRoomDatabase : RoomDatabase() {
    abstract fun partidoDa() : partidoDao

    companion object {
        @Volatile
        private var INSTANCE: PartidoRoomDatabase? = null

        fun getDatabase(
            context: Context
        ): PartidoRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PartidoRoomDatabase::class.java,
                    "partido_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}