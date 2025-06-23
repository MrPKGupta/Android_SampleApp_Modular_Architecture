package com.pkgupta.sampleapp.domain.usecases

import com.pkgupta.sampleapp.domain.models.User
import com.pkgupta.sampleapp.domain.repository.UserRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetUsersTest {

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    private lateinit var repository: UserRepository
    private lateinit var useCase: GetUsers

    @Before
    fun setup() {
        repository = mockk()
        useCase = GetUsers(repository)
    }

    @Test
    fun testBlankFields(): Unit = testScope.runTest {
        val users = listOf(
            User(
                id = 1,
                name = "John Cena",
                email = "",
                company = "",
                address = "Church Street",
                photo = "https://abc.com/pic1.png"
            ),
            User(
                id = 2,
                name = "Bob Smith",
                email = "bob@example.com",
                company = "Dev Inc.",
                address = "MG Road",
                photo = "https://abc.com/pic2.png"
            )
        )
        coEvery { repository.getUsers() } returns flowOf(users)

        val result = useCase().first()

        assertEquals("NA", result[0].email)
        assertEquals("NA", result[0].company)
        assertEquals("bob@example.com", result[1].email)
        assertEquals("Dev Inc.", result[1].company)
    }
}
