package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote

import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.dto.CoinDto
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.utils.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface CoinPaprikaApi{

    @GET(HttpRoutes.COINS)
    suspend fun getCoins(): Response<List<CoinDto>>

}