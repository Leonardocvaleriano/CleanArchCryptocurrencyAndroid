package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.use_cases

import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    suspend operator fun invoke() = repository.getCoins()
}
