package com.ecodeli.client.repository

import com.ecodeli.client.model.Annonce
import com.ecodeli.client.network.ApiService

class AnnonceRepository(private val api: ApiService) {
    suspend fun getAnnonces(): List<Annonce> = api.getAnnonces()
}
