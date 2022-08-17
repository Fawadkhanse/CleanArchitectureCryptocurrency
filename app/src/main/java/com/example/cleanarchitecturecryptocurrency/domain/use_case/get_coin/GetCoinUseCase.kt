package com.example.cleanarchitecturecryptocurrency.domain.use_case.get_coin

import com.example.cleanarchitecturecryptocurrency.common.Resource
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.toCoinDetail
import com.example.cleanarchitecturecryptocurrency.domain.model.CoinDetail
import com.example.cleanarchitecturecryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val  repository: CoinRepository
) {
    operator fun invoke(coinId :String) :Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Loading<CoinDetail>(coin))
        }catch (e:HttpException){
            emit(Resource.Error<CoinDetail>(e.code().toString()?:"An unexpected error occured"))
        }catch (e:IOException){
            emit(Resource.Error<CoinDetail>(e.message?:"Couldn't reach server. Check your internet connection."))
        }
    }
}