package com.example.cleanarchitecturecryptocurrency.domain.use_case.get_coins


import com.example.cleanarchitecturecryptocurrency.common.Resource
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.toAllCoins
import com.example.cleanarchitecturecryptocurrency.domain.model.AllCoins
import com.example.cleanarchitecturecryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
     fun getCoins(
         currency: String,
         ids: String,
         order: String,
         perPage: Int,
         page: Int,
         sparkline: Boolean,
         priceChangePercentage: String,
    ): Flow<Resource<List<AllCoins>>> = flow{
        try {
            emit(Resource.Loading<List<AllCoins>>())
            val coins = repository.getCoins(currency, ids, order, perPage, page, sparkline, priceChangePercentage).map { it.toAllCoins() }
            emit(Resource.Success<List<AllCoins>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<AllCoins>>(e.localizedMessage.toString() ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<AllCoins>>(e.message+"Couldn't reach server. Check your internet connection."))
        }
    }
}