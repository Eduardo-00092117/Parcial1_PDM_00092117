package com.example.basquetballparcial.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.basquetballparcial.Entities.partido
import com.example.basquetballparcial.PartidoRoomDatabase
import com.example.basquetballparcial.Repositorio.repositoryPartido
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : repositoryPartido
    val allPartido : LiveData<List<partido>>

    init {
        val partidoDao = PartidoRoomDatabase.getDatabase(application).partidoDa()
        repository = repositoryPartido(partidoDao)

        allPartido = partidoDao.getAll()
    }

    fun insert(partido : partido) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(partido)
    }
}