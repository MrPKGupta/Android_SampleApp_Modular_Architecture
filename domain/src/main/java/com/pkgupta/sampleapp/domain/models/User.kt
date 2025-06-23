package com.pkgupta.sampleapp.domain.models

data class User(
    val id: Int,
    val name: String,
    val company: String,
    val email: String,
    val address: String,
    val photo: String
)
