package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.utils

import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.utils.Error

enum class NetworkError : Error {
    REQUEST_TIMEOUT,
    UNAUTHORIZED,
    CONFLICT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    PAYLOAD_TOO_LARGE,
    SERVER_ERROR,
    SERIALIZATION,
    UNABLE_TO_CONNECT,
    UNKNOWN;
}