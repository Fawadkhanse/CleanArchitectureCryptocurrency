package com.example.cleanarchitecturecryptocurrency.presention.fragment.coin_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecturecryptocurrency.R
import com.example.cleanarchitecturecryptocurrency.databinding.FragmentCoinsBinding
import com.example.cleanarchitecturecryptocurrency.domain.model.Coin
import com.example.cleanarchitecturecryptocurrency.presention.fragment.coin_list.adapter.CoinAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinsFragment : Fragment(),CoinAdapter.ItemClicked {
    private val viewModel by viewModels<CoinViewModel>()
    private  lateinit var coinList: List<Coin>
    private var binding: FragmentCoinsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCoinsBinding.inflate(inflater, container, false)
        initEvent()
        return binding?.root
    }

    private fun initEvent() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    if (state.isLoading) {
                        Log.d("TAG", "isLoading: ")

                    } else if (state.coins.isNotEmpty()) {
                        Log.d("TAG", "isNotEmpty: ")
                        coinList = state.coins
                        setRecycler(state.coins)
                    } else if (state.error.isNotEmpty()) {
                        Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()
                        Log.d("TAG", "error: ${state.error}")
                    }
                }
            }

        }
    }

    private fun setRecycler(coins: List<Coin>) {
        binding?.recyler?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyler?.adapter = CoinAdapter(coins,this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun clicked(position: Int) {
        val item = coinList[position]
        Navigation.findNavController(binding!!.root).navigate(R.id.action_coinsFragment2_to_coinDetailFragment2)
    }

}