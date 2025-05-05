package com.example.healthapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.example.healthapp.ui.screens.home.HomeScreen
import com.example.healthapp.ui.screens.home.HomeViewModel
import com.example.healthapp.ui.theme.Purple80
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(color = Purple80) {
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}
