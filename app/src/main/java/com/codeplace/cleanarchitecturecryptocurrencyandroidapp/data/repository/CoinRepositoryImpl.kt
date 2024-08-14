package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.repository

import android.util.Log
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.CoinPaprikaApi
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.mappers.toDomain
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.utils.NetworkError
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.model.Coin
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.repository.CoinRepository
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.utils.Result
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val TAG = "CoinRepositoryImpl"

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return try {
            val response = api.getCoins()
            if (response.isSuccessful) {
                Log.d(TAG, "Response: ${response.body()}")
                val coinsResponse = response.body()!!
                Result.Success(coinsResponse.map { it.toDomain() })
            } else {
                when (response.code()) {
                    429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
                    else -> Result.Error(NetworkError.UNKNOWN)
                }
            }
        } catch (e: HttpException) {
            Log.d(TAG, "HttpException: ${e.message()}")
            Result.Error(NetworkError.SERVER_ERROR)
        } catch (e: IOException) {
            Log.d(TAG, "IOException: ${e.message}")
            Result.Error(NetworkError.NO_INTERNET)
        }

    }
}