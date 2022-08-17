package com.example.cleanarchitecturecryptocurrency.presention.fragment.coin_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanarchitecturecryptocurrency.R
import com.example.cleanarchitecturecryptocurrency.databinding.CoinItemBinding
import com.example.cleanarchitecturecryptocurrency.domain.model.AllCoins
import javax.inject.Inject

class CoinAdapter @Inject constructor(
    private val coinList: List<AllCoins>,
    private val itemClicked: ItemClicked
) : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {
    class ViewHolder(val itemv: CoinItemBinding, private val itemClicked: ItemClicked) : RecyclerView.ViewHolder(itemv.root) {
        init {
            itemv.root.setOnClickListener {
                itemClicked.clicked(absoluteAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CoinItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),itemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = coinList[position]
        Glide.with(holder.itemv.root)
            .load(item.image)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemv.textView)
       holder.itemv.textView2.text = item.name
       holder.itemv.textView3.text = item.symbol
    }

    override fun getItemCount(): Int {
       return coinList!!.size
    }
    interface ItemClicked{
        fun clicked(position:Int)
    }
}