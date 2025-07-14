package com.ecodeli.client.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val token: String,
    val name: String
)
