package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.presentation.ui.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.model.Coin

@Composable
fun CoinsScreen(
    coins: List<Coin>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 80.dp, bottom = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        items(coins) { coin ->
            Box(
                modifier = modifier.padding(bottom = 32.dp)
            )
            {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Text(
                            text = coin.rank.toString() + ".",
                            style = MaterialTheme.typography.bodyLarge

                        )
                        Spacer(Modifier.padding(horizontal = 2.dp))

                        FixedLengthText(coin.name, 16)

                        Spacer(Modifier.padding(horizontal = 2.dp))
                        Text(
                            text = "(${coin.symbol})",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    if (coin.isActive) {
                        Text(
                            text = "Active",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyLarge


                        )
                    } else {
                        Text(
                            text = "Inactive",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable

fun CoinsScreenPreview() {

    CoinsScreen(
        coins = listOf(
            Coin(
                id = "1",
                isActive = true,
                name = "Bitcoin",
                rank = 1,
                symbol = "BTC"
            ),
            Coin(
                id = "1",
                isActive = true,
                name = "Bitcoin",
                rank = 1,
                symbol = "BTC"
            )
        )
    )
}

@Composable
fun FixedLengthText(text: String, maxLength: Int) {
    val truncatedText = if (text.length > maxLength) {
        text.take(maxLength) + "..."
    } else {
        text
    }

    Text(
        text = truncatedText,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.bodyMedium,
    )
}