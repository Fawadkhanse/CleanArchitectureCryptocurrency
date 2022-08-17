package com.example.cleanarchitecturecryptocurrency.data.repository

import com.example.cleanarchitecturecryptocurrency.data.remote.CoinApi
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinDetailDto
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinListDtoItem
import com.example.cleanarchitecturecryptocurrency.domain.repository.CoinRepository
import retrofit2.Response
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi,
) : CoinRepository {
    override suspend fun getCoins(
        currency: String,
        ids: String,
        order: String,
        perPage: Int,
        page: Int,
        sparkline: Boolean,
        priceChangePercentage: String,

        ):
            List<CoinListDtoItem> {
        return api.getCoins(currency, ids, order, perPage, page, sparkline, priceChangePercentage)
    }


    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}