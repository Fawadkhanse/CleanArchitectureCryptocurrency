package com.example.cleanarchitecturecryptocurrency.domain.repository

import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinDetailDto
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinDto


interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}