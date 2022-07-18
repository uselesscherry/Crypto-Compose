package com.cherry.cryptocompose.domain

import com.cherry.cryptocompose.domain.model.CoinDetailed

interface Repository {
suspend fun getCoins():List<CoinDetailed>
}