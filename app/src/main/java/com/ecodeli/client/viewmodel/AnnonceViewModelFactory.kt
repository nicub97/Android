package com.ecodeli.client.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ecodeli.client.repository.AnnonceRepository

class AnnonceViewModelFactory(private val repo: AnnonceRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnnonceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnnonceViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
