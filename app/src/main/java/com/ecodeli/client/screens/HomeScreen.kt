package com.ecodeli.client.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ecodeli.client.repository.UserPreferences

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val prefs = remember { UserPreferences(context) }
    var name by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        name = prefs.getName() ?: ""
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Bienvenue $name!")
    }
}
