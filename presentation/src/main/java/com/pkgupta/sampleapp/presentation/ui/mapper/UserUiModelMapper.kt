package com.pkgupta.sampleapp.presentation.ui.mapper

import com.pkgupta.sampleapp.domain.models.User
import com.pkgupta.sampleapp.presentation.ui.models.UserUiModel

fun User.toUserUiModel(): UserUiModel {
    return UserUiModel(
        id = this.id,
        name = this.name,
        email = this.email,
        photo = this.photo
    )
}