package com.mustafa.userapp.app.data.networking.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//! Id Ekle
@Serializable
data class UserDto(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val gender: String,
    val image: String,
    val address: UserAddress
)