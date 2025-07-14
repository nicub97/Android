package com.ecodeli.client.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecodeli.client.model.Annonce
import com.ecodeli.client.repository.AnnonceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AnnonceViewModel(private val repo: AnnonceRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<AnnonceState>(AnnonceState.Loading)
    val uiState: StateFlow<AnnonceState> = _uiState

    init {
        fetchAnnonces()
    }

    fun fetchAnnonces() {
        viewModelScope.launch {
            _uiState.value = AnnonceState.Loading
            try {
                val annonces = repo.getAnnonces()
                _uiState.value = AnnonceState.Success(annonces)
            } catch (e: Exception) {
                _uiState.value = AnnonceState.Error(e.message ?: "Unknown error")
            }
        }
    }

    sealed class AnnonceState {
        object Loading : AnnonceState()
        data class Success(val annonces: List<Annonce>) : AnnonceState()
        data class Error(val message: String) : AnnonceState()
    }
}
