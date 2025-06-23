package com.pkgupta.sampleapp.domain.usecases

import com.pkgupta.sampleapp.domain.models.User
import com.pkgupta.sampleapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetUsers(private val repository: UserRepository) {
    operator fun invoke(): Flow<List<User>> =
        repository.getUsers().map { users ->
            users.map { user ->
                user.copy(
                    email = user.email.takeUnless { it.isBlank() } ?: "NA",
                    company = user.company.takeUnless { it.isBlank() } ?: "NA")
            }
        }
}