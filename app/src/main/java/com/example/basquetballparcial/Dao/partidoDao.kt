package com.example.basquetballparcial.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basquetballparcial.Entities.partido

@Dao
interface partidoDao {

    @Query("SELECT * FROM partidos")
    fun getAll() : LiveData<List<partido>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido: partido)

}