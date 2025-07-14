package com.ecodeli.client.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ecodeli.client.di.Injector
import com.ecodeli.client.model.Annonce
import com.ecodeli.client.viewmodel.AnnonceViewModel
import com.ecodeli.client.viewmodel.AnnonceViewModelFactory

@Composable
fun AnnonceListScreen(onAnnonceSelected: (Annonce) -> Unit) {
    val context = LocalContext.current
    val viewModel: AnnonceViewModel = viewModel(factory = AnnonceViewModelFactory(Injector.provideAnnonceRepository(context)))
    val state by viewModel.uiState.collectAsState()

    when (val s = state) {
        is AnnonceViewModel.AnnonceState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("Chargement...")
            }
        }
        is AnnonceViewModel.AnnonceState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("Erreur: ${'$'}{s.message}")
            }
        }
        is AnnonceViewModel.AnnonceState.Success -> {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                items(s.annonces) { annonce ->
                    AnnonceCard(annonce, onAnnonceSelected)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun AnnonceCard(annonce: Annonce, onClick: (Annonce) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable { onClick(annonce) }.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = annonce.titre)
            Text(text = "${'$'}{annonce.villeDepart} → ${'$'}{annonce.villeArrivee}")
            annonce.type?.let { Text(text = it) }
            Text(text = annonce.dateDepot)
        }
    }
}
