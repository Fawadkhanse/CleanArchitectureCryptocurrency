package com.example.cleanarchitecturecryptocurrency.di

import android.app.Activity
import com.example.cleanarchitecturecryptocurrency.common.Const
import com.example.cleanarchitecturecryptocurrency.data.remote.CoinApi
import com.example.cleanarchitecturecryptocurrency.data.repository.CoinRepositoryImpl
import com.example.cleanarchitecturecryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)

    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }


}