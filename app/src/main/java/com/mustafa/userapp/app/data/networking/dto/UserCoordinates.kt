package com.mustafa.userapp.app.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserCoordinates(
    val lat: Double,
    val lng: Double
)
