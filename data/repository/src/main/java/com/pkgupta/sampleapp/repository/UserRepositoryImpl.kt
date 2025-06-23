package com.pkgupta.sampleapp.repository

import com.pkgupta.sampleapp.api.users.UserApi
import com.pkgupta.sampleapp.domain.models.User
import com.pkgupta.sampleapp.domain.repository.UserRepository
import com.pkgupta.sampleapp.repository.mapper.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(
    private val userApi: UserApi
) : UserRepository {

    override fun getUsers(): Flow<List<User>> = flow {
        val users = userApi.getUsers().map { it.toDomain() }
        emit(users)
    }
}