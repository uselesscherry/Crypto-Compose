package com.cherry.cryptocompose.data.remote

import com.cherry.cryptocompose.domain.model.Coin
import com.cherry.cryptocompose.domain.model.CoinDetailed
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    companion object {
        const val BASE_URL = "https://api.coinpaprika.com"
    }

    @GET("/v1/coins")
    suspend fun getCoins(): List<Coin>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailed

}