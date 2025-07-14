package com.ecodeli.client.model

import com.google.gson.annotations.SerializedName

data class Annonce(
    val id: Int,
    val titre: String,
    @SerializedName("ville_depart") val villeDepart: String,
    @SerializedName("ville_arrivee") val villeArrivee: String,
    val type: String?,
    @SerializedName("date_depot") val dateDepot: String,
    val description: String?,
    val prix: Double?,
    val distance: Double?,
    @SerializedName("transport_souhaite") val transportSouhaite: String?
)
