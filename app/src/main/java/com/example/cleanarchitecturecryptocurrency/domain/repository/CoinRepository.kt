package com.example.cleanarchitecturecryptocurrency.domain.repository

import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinDetailDto

import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinListDtoItem


interface CoinRepository {

    suspend fun getCoins(
        currency: String,
        ids: String,
        order: String,
        perPage: Int,
        page: Int,
        sparkline: Boolean,
        priceChangePercentage: String,
    ): List<CoinListDtoItem>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}