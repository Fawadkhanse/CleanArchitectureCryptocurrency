package com.example.cleanarchitecturecryptocurrency.presention.fragment.coin_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturecryptocurrency.databinding.CoinItemBinding
import com.example.cleanarchitecturecryptocurrency.domain.model.Coin
import javax.inject.Inject

class CoinAdapter @Inject constructor(
    private val coinList: List<Coin>,
    private val itemClicked: ItemClicked
) : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {
    class ViewHolder(val itemv: CoinItemBinding,val itemClicked: ItemClicked) : RecyclerView.ViewHolder(itemv.root) {
        init {
            itemv.root.setOnClickListener {
                itemClicked.clicked(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CoinItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),itemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = coinList[position]
       holder.itemv.textView.text =item.id
       holder.itemv.textView2.text =item.name
       holder.itemv.textView3.text = item.symbol
    }

    override fun getItemCount(): Int {
       return coinList.size
    }
    interface ItemClicked{
        fun clicked(position:Int)
    }
}