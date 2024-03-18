package com.example.practica_8.core

import android.app.Application
import com.example.practica_8.data.LocalRepository
import com.example.practica_8.data.database.ModulosDatabase

class ModuloApp: Application() {
    private val database: ModulosDatabase by lazy { ModulosDatabase.getDataBase(this) }
    val localRepo: LocalRepository by lazy { LocalRepository(database) }

}