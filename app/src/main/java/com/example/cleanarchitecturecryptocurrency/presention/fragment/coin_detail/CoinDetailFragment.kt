package com.example.cleanarchitecturecryptocurrency.presention.fragment.coin_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cleanarchitecturecryptocurrency.databinding.FragmentCoinsBinding


class CoinDetailFragment : Fragment() {
   private var binding  :FragmentCoinsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentCoinsBinding.inflate(inflater, container, false)

        return  binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}