package com.pkgupta.sampleapp.domain.repository

import com.pkgupta.sampleapp.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>
}