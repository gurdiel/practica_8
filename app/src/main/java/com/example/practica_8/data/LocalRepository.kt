package com.example.practica_8.data

import androidx.lifecycle.LiveData
import com.example.practica_8.data.database.Modulos
import com.example.practica_8.data.database.ModulosDatabase

class LocalRepository(private val dataBase: ModulosDatabase) {
    private val dao = dataBase.dao()

    val allModulos: LiveData<List<Modulos>> = dao.getAllModulos()

    suspend fun insertModulo(nom_modulo: String, creditos: String){
        val moduloEntity = Modulos(modulo = nom_modulo, creditos = creditos)
        dao.insertModulo(moduloEntity)
    }
    suspend fun clearModulos() = dao.deleteModulos()

}