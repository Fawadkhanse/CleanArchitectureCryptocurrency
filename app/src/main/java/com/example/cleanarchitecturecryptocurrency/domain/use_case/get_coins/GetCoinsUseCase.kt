package com.example.cleanarchitecturecryptocurrency.domain.use_case.get_coins


import com.example.cleanarchitecturecryptocurrency.common.Resource
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.toCoin
import com.example.cleanarchitecturecryptocurrency.domain.model.Coin
import com.example.cleanarchitecturecryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.code().toString() ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>(e.message+"Couldn't reach server. Check your internet connection."))
        }
    }
}