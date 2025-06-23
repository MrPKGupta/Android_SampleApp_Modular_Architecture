package com.pkgupta.sampleapp.repository

import com.pkgupta.sampleapp.api.users.UserApi
import com.pkgupta.sampleapp.api.users.model.UserDto
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest {

    private lateinit var api: UserApi
    private lateinit var repository: UserRepositoryImpl

    @Before
    fun setup() {
        api = mockk()
        repository = UserRepositoryImpl(api)
    }

    @Test
    fun testUserDtoMapping() = runTest {

        val dtoList = listOf(
            UserDto(
                1,
                "John",
                "Company A",
                "john@example.com",
                "123 Main St",
                "https://example.com/john.jpg"
            ),
            UserDto(
                2,
                "Mahesh",
                "Company B",
                "mahesh@example.com",
                "456 Elm St",
                "https://example.com/mahesh.jpg"
            )
        )
        coEvery { api.getUsers() } returns dtoList

        val users = repository.getUsers().first()

        assertEquals(2, users.size)
        assertEquals("John", users[0].name)
        assertEquals("mahesh@example.com", users[1].email)
    }
}
