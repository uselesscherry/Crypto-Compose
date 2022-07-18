package com.cherry.cryptocompose.di

import com.cherry.cryptocompose.data.RepositoryImpl
import com.cherry.cryptocompose.data.remote.CoinApi
import com.cherry.cryptocompose.domain.Repository
import com.cherry.cryptocompose.presentation.CoinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<CoinApi> {
        Retrofit.Builder()
            .baseUrl(CoinApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    single<Repository> { RepositoryImpl(get()) }

    viewModel { CoinViewModel(get()) }

}