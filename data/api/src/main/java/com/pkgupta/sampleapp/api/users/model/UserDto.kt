package com.pkgupta.sampleapp.api.users.model

data class UserDto(
    val id: Int,
    val name: String,
    val company: String,
    val email: String,
    val address: String,
    val photo: String
)