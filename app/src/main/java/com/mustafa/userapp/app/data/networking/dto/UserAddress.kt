package com.mustafa.userapp.app.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserAddress(
    val address: String,
    val city: String,
    val coordinates: UserCoordinates,
    val country: String
)
