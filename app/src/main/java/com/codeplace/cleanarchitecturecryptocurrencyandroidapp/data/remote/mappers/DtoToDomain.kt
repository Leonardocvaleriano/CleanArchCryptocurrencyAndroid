package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.mappers

import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.dto.CoinDto
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.model.Coin


fun CoinDto.toDomain(): Coin {
    return Coin(
        id = id ,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}