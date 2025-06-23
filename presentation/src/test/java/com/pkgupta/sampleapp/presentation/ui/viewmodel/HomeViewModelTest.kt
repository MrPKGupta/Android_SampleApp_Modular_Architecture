package com.pkgupta.sampleapp.presentation.ui.viewmodel

import app.cash.turbine.test
import com.pkgupta.sampleapp.domain.models.User
import com.pkgupta.sampleapp.domain.usecases.GetUsers
import com.pkgupta.sampleapp.presentation.ui.base.UIState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    private lateinit var getUsers: GetUsers
    private lateinit var viewModel: HomeViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getUsers = mockk()
        viewModel = HomeViewModel(getUsers)
    }

    @Test
    fun testLoadingAndSuccess() = runTest {

        val domainUsers = listOf(
            User(
                1,
                "John",
                "Company A",
                "john@example.com",
                "123 Street",
                "https://abc.com/pic1.png"
            ),
            User(
                2,
                "Mahesh",
                "Company B",
                "mahesh@example.com",
                "456 Street",
                "https://abc.com/pic2.png"
            )
        )
        coEvery { getUsers() } returns flowOf(domainUsers)


        viewModel.uiState.test {
            assertEquals(UIState.Initial, awaitItem())
            viewModel.loadUsers()
            assertEquals(UIState.Loading, awaitItem())

            val success = awaitItem()
            assertTrue(success is UIState.Success)
            val users = (success as UIState.Success).data

            assertEquals("John", users[0].name)
            assertEquals("mahesh@example.com", users[1].email)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun testLoadingAndError() = runTest {
        coEvery { getUsers() } throws Exception("API failed")

        viewModel.uiState.test {
            assertEquals(UIState.Initial, awaitItem())

            viewModel.loadUsers()

            assertEquals(UIState.Loading, awaitItem())

            val error = awaitItem()
            assertTrue(error is UIState.Error)
            assertEquals("API failed", (error as UIState.Error).message)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
