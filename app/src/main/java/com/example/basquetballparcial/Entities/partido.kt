package com.example.basquetballparcial.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partidos")
data class partido (
    @ColumnInfo(name = "equipo1") val equipo1 : String,
    @ColumnInfo(name = "equipo2") val equipo2 : String,
    @ColumnInfo(name = "puntuacion1") val puntuacion1: Int,
    @ColumnInfo(name = "puntuacion2") val puntuacion2: Int,
    @ColumnInfo(name = "ganador") val ganador : String,
    @ColumnInfo(name = "fecha") val fecha : String,
    @ColumnInfo(name = "hora") val hora : String
){
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_partido") var id : Long = 0
}