package com.pkgupta.sampleapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pkgupta.sampleapp.presentation.ui.screens.DetailsScreen
import com.pkgupta.sampleapp.presentation.ui.screens.HomeScreen

/**
 * Composable function that defines the navigation graph for the Sample app.
 *
 * This function sets up the NavHost with two destinations:
 * - [Screen.Home]: The home screen of the app, displaying a list of users.
 *   - When an item is clicked, it navigates to the [Screen.Details] screen, passing the selected [User] object.
 * - [Screen.Details]: The details screen, displaying information about a selected user.
 *
 * @param navController The [NavHostController] used to manage navigation within the app.
 *                      Defaults to a new controller remembered by [rememberNavController].
 * @param startDestination The route of the initial screen to be displayed.
 *                         Defaults to [Screen.Home.route].
 */
@Composable
fun SampleAppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController, onItemClick = { user ->
                navController.currentBackStackEntry?.savedStateHandle?.set("user", user)
                navController.navigate(Screen.Details.route)
            })
        }

        composable(
            route = Screen.Details.route,
        ) {
            DetailsScreen(
                navController = navController,
            )
        }
    }
}
