package com.ecodeli.client.repository

import com.ecodeli.client.model.LoginRequest
import com.ecodeli.client.network.ApiService

class AuthRepository(private val api: ApiService, private val prefs: UserPreferences) {
    suspend fun login(email: String, password: String) = api.login(LoginRequest(email, password)).also {
        prefs.saveToken(it.token)
        prefs.saveName(it.name)
    }
}
