package com.pkgupta.sampleapp.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.pkgupta.sampleapp.presentation.R
import com.pkgupta.sampleapp.presentation.ui.models.UserUiModel

/**
 * Composable function that displays the details screen.
 *
 * This screen shows details of a selected item, identified by its ID.
 * It retrieves the item's data (specifically a `User` object) from the navigation arguments.
 *
 * @param navController The [NavController] used for navigating back to the previous screen.
 * @param modifier The [Modifier] to be applied to the root composable of this screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val user: UserUiModel? =
        navController.previousBackStackEntry?.savedStateHandle?.get<UserUiModel>("user")

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.title_user_details)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                user?.photo?.run {
                    NetworkImage(
                        this,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.title_name, user?.name ?: ""),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = modifier.fillMaxWidth().padding(horizontal = 32.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.title_email, user?.email ?: ""),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = modifier.fillMaxWidth().padding(horizontal = 32.dp)
                )
            }
        }
    }
}

@Composable
fun NetworkImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}
