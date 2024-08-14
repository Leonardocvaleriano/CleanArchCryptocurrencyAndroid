package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.presentation.ui.coin_list


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.model.Coin
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.use_cases.GetCoinsUseCase
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
     val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {



    var coins by mutableStateOf<List<Coin>>(emptyList())
        private set

    var error by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set


    init {
        getCoins()
    }

    private fun getCoins() = viewModelScope.launch {
        isLoading = true
        when (val result = getCoinsUseCase()) {
            is Result.Success -> {
                coins = result.data
            }
            is Result.Error -> {
                error = result.error.name
            }
        }
        isLoading = false
    }
}