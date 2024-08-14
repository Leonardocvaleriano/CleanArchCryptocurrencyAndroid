package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.utils

object HttpRoutes {
    const val BASE_URL = "https://api.coinpaprika.com"
    const val COINS = "$BASE_URL/v1/coins"
    const val COIN = "$BASE_URL/v1/coins/{coinId}"
}