package com.pkgupta.sampleapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pkgupta.sampleapp.presentation.navigation.SampleAppNavHost
import com.pkgupta.sampleapp.presentation.ui.theme.SampleAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAppTheme {
                SampleAppNavHost()
            }
        }
    }
}

@Composable
fun SampleApp() {
    SampleAppNavHost()
}

@Preview
@Composable
fun SampleAppPreview() {
    SampleAppTheme {
        SampleApp()
    }
}