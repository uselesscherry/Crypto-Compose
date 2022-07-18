package com.cherry.cryptocompose.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cherry.cryptocompose.domain.Repository
import com.cherry.cryptocompose.domain.model.CoinDetailed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoinViewModel(
    private val repository: Repository
) : ViewModel() {


    private val _coins = mutableStateOf(emptyList<CoinDetailed>())
    val coins: State<List<CoinDetailed>> = _coins



    val isLoaded: Boolean
        get() = coins.value.isNotEmpty()

    init {
        getCoins()
    }

    fun getCoins() {
        viewModelScope.launch(Dispatchers.IO) {
            _coins.value=repository.getCoins()
        }

    }

}