package com.mustafa.userapp.app.data.mappers

import com.mustafa.userapp.app.data.networking.dto.UserDto
import com.mustafa.userapp.app.domain.User

fun UserDto.toUser(): User {
    return User(
        firstName = firstName,
        lastName = lastName,
        age = age,
        gender = gender,
        image = image,
        address = address.address,
        city = address.city,
        lat = address.coordinates.lat,
        lng = address.coordinates.lng,
        country = address.country
    )
}
