package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.presentation.ui.coin_list.CoinListViewModel
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.presentation.ui.coin_list.CoinsScreen
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.presentation.ui.theme.CleanArchitectureCryptocurrencyAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setComposeContent()
    }
}

private fun ComponentActivity.setComposeContent() {
    enableEdgeToEdge()
    setContent {
        CleanArchitectureCryptocurrencyAndroidAppTheme {
            Surface(
                color = MaterialTheme.colorScheme.surface
            ) {
                val viewModel = hiltViewModel<CoinListViewModel>()

                if (viewModel.isLoading) {
                    Box(
                        modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                } else {
                    CoinsScreen(viewModel.coins)
                }
            }
        }
    }
}

