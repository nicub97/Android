package com.ecodeli.client.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ecodeli.client.model.Annonce

@Composable
fun AnnonceDetailScreen(annonce: Annonce) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = annonce.titre)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "${'$'}{annonce.villeDepart} → ${'$'}{annonce.villeArrivee}")
        annonce.type?.let { Text(text = it) }
        Text(text = annonce.dateDepot)
        annonce.description?.let { Text(text = it) }
        annonce.prix?.let { Text(text = "Prix: ${'$'}it €") }
        annonce.distance?.let { Text(text = "Distance: ${'$'}it km") }
        annonce.transportSouhaite?.let { Text(text = "Transport: ${'$'}it") }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO reservation */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Réserver")
        }
    }
}
