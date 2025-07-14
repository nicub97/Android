package com.ecodeli.client.di

import android.content.Context
import com.ecodeli.client.network.AuthInterceptor
import com.ecodeli.client.network.RetrofitClient
import com.ecodeli.client.repository.AuthRepository
import com.ecodeli.client.repository.AnnonceRepository
import com.ecodeli.client.repository.UserPreferences

object Injector {
    fun provideAuthRepository(context: Context): AuthRepository {
        val prefs = UserPreferences(context)
        val api = RetrofitClient.createApiService(AuthInterceptor(prefs))
        return AuthRepository(api, prefs)
    }

    fun provideAnnonceRepository(context: Context): AnnonceRepository {
        val prefs = UserPreferences(context)
        val api = RetrofitClient.createApiService(AuthInterceptor(prefs))
        return AnnonceRepository(api)
    }
}
