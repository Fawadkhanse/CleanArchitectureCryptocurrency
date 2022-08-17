package com.example.cleanarchitecturecryptocurrency.presention.fragment.coin_list

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturecryptocurrency.common.Resource
import com.example.cleanarchitecturecryptocurrency.domain.model.CoinListState
import com.example.cleanarchitecturecryptocurrency.domain.use_case.get_coin.GetCoinUseCase
import com.example.cleanarchitecturecryptocurrency.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val GetCoinsUseCase: GetCoinsUseCase
): ViewModel() {
    private val _state = MutableStateFlow(CoinListState())
    val state: StateFlow<CoinListState> = _state
    init {
        getCoins()
    }

    private fun getCoins() {
            GetCoinsUseCase().onEach {result ->
                when(result){
                    is Resource.Loading ->{
                        _state.value  = CoinListState(isLoading =  true)
                    }
                    is Resource.Success ->{
                        _state.value = CoinListState(coins = result.data?: emptyList())

                    }
                    is Resource.Error ->{
                        _state.value = CoinListState( error = result.message?:"An unexpected error occured")

                    }

                }
            }.launchIn(viewModelScope)


    }

}