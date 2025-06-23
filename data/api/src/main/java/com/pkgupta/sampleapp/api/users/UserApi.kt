package com.pkgupta.sampleapp.api.users

import com.pkgupta.sampleapp.api.users.model.UserDto
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<UserDto>
}