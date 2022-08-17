package com.example.cleanarchitecturecryptocurrency.domain.model

import com.example.cleanarchitecturecryptocurrency.data.remote.dato.TeamMember


data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
