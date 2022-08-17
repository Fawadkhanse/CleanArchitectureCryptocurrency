package com.example.cleanarchitecturecryptocurrency.data.remote

import android.telecom.Call
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinDetailDto
import com.example.cleanarchitecturecryptocurrency.data.remote.dato.CoinListDtoItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {
    //    @GET("/v1/coins")
//    suspend fun getCoins(): List<CoinDto>

//    suspend fun getCoins(
//        @Query ("vs_currency") currency:String,
//        ): List<CoinListDtoItem>
 //   @GET("/v3/coins/markets")
//    suspend fun getCoins(
//        @Query ("vs_currency") currency:String,
//        @Query ("order") order:String,
//        @Query ("per_page") perPage: Int,
//        @Query ("page") page: Int,
//        @Query ("sparkline") sparkline: Boolean,
//        @Query ("price_change_percentage") priceChangePercentage:String,
//        ): List<CoinListDtoItem>
@GET("coins/markets")
  suspend fun getCoins(
    @Query("vs_currency") vsCurrency: String, @Query("ids") ids: String,
    @Query("order") order: String,
    @Query("per_page") perPage: Int?, @Query("page") page: Int?,
    @Query("sparkline") sparkline: Boolean,
    @Query("price_change_percentage") priceChangePercentage: String,
        ): List<CoinListDtoItem>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}