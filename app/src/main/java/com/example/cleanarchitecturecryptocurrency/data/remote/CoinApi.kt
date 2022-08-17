package com.example.cleanarchitecturecryptocurrency.data.remote

import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinDetailDto
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}