package com.example.basquetballparcial.Repositorio

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.basquetballparcial.Database.Dao.partidoDao
import com.example.basquetballparcial.Database.Entities.partido

class repositoryPartido(private val partidoDao : partidoDao) {

    fun getAll() : LiveData<List<partido>> = partidoDao.getAll()

    @WorkerThread
    suspend fun insert(partido : partido) = partidoDao.insert(partido)

}