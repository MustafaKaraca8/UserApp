package com.mustafa.userapp.app.domain

data class User(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val gender: String,
    val image: String,
    val address: String,
    val city: String,
    val lat: Double,
    val lng: Double,
    val country: String
)
