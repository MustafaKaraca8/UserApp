package com.mustafa.userapp.app.data.networking.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersResponseDto(
    @SerialName("users") val data: List<UserDto>
)
