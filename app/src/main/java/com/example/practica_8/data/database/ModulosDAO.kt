package com.example.practica_8.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ModulosDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModulo(modulo:Modulos)

    @Query("DELETE FROM modulos")
    suspend fun deleteModulos()

    @Query("SELECT * FROM modulos ORDER BY id DESC")
    fun getAllModulos(): LiveData<List<Modulos>>

}