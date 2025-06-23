package com.pkgupta.sampleapp.repository.mapper

import com.pkgupta.sampleapp.api.users.model.UserDto
import com.pkgupta.sampleapp.domain.models.User

fun UserDto.toDomain(): User {
    return User(
        id = this.id,
        name = this.name,
        email = this.email,
        company = this.company,
        address = this.address,
        photo = this.photo
    )
}