package com.ecodeli.client.network

import com.ecodeli.client.model.LoginRequest
import com.ecodeli.client.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}
