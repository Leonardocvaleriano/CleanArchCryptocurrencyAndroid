package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.repository

import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.utils.NetworkError
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.model.Coin
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.utils.Result

interface CoinRepository {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}