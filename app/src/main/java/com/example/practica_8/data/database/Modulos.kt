package com.example.practica_8.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "modulos")
data class Modulos(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "nombre_modulo") val modulo: String,
    @ColumnInfo(name = "creditos_modulo") val creditos: String,
    val timestamp: Long = System.currentTimeMillis()
)
