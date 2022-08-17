package com.example.cleanarchitecturecryptocurrency.domain.model

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<AllCoins> = emptyList(),
    val error: String = ""
)