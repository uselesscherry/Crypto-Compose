package com.cherry.cryptocompose.data

import com.cherry.cryptocompose.data.remote.CoinApi
import com.cherry.cryptocompose.domain.Repository
import com.cherry.cryptocompose.domain.model.CoinDetailed

class RepositoryImpl(private val api: CoinApi) : Repository {

    override suspend fun getCoins(): List<CoinDetailed> {
        return api.getCoins().take(25).map { coin ->

                api.getCoinById(coin.id)

        }
    }
}