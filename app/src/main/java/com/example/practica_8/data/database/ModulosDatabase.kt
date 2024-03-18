package com.example.practica_8.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Modulos::class])
abstract class ModulosDatabase: RoomDatabase() {
    abstract fun dao(): ModulosDAO

    companion object{
        @Volatile
        private var INSTANCE: ModulosDatabase? = null

        fun getDataBase(context:Context): ModulosDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    ModulosDatabase::class.java,
                    "modulos_Database")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}