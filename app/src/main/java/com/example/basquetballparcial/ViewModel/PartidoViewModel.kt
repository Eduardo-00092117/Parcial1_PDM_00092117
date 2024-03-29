package com.example.basquetballparcial.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.basquetballparcial.Database.Entities.partido
import com.example.basquetballparcial.Database.PartidoRoomDatabase
import com.example.basquetballparcial.Repositorio.repositoryPartido
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : repositoryPartido
    val allPartido : LiveData<List<partido>>
    var puntuacionA : Int = 0
    var puntuacionB : Int = 0

    init {
        val partidoDao = PartidoRoomDatabase.getDatabase(application).partidoDa()
        repository = repositoryPartido(partidoDao)

        allPartido = partidoDao.getAll()
    }

    fun insert(partido : partido) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(partido)
    }
}