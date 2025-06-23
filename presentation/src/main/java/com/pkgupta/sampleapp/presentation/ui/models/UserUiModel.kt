package com.pkgupta.sampleapp.presentation.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserUiModel(
    val id: Int,
    val name: String,
    val email: String,
    val photo: String
): Parcelable