package com.example.practica_8.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.practica_8.core.ModuloApp
import com.example.practica_8.data.LocalRepository
import kotlinx.coroutines.launch

class Modelo(val repository: LocalRepository): ViewModel() {

    val allModulos = repository.allModulos

    fun guardar(modulo:String, creditos:String) {
        viewModelScope.launch {
            repository.insertModulo(modulo, creditos)
        }
    }
    fun clearModulos(){  viewModelScope.launch { repository.clearModulos() } }
}

class ModelVMFactory(): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val app = checkNotNull(extras[APPLICATION_KEY]) as ModuloApp
        val repo = app.localRepo
        return Modelo(repo) as T
    }
}