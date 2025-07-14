package com.ecodeli.client.network

import com.ecodeli.client.model.LoginRequest
import com.ecodeli.client.model.LoginResponse
import com.ecodeli.client.model.Annonce
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("client/annonces")
    suspend fun getAnnonces(): List<Annonce>
}
