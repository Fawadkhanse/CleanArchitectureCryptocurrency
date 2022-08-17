package com.example.cleanarchitecturecryptocurrency.data.repository

import com.example.cleanarchitecturecryptocurrency.data.remote.CoinApi
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinDetailDto
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinDto
import com.example.cleanarchitecturecryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}