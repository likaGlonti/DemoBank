package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.common.bindWith
import com.example.presentation.databinding.CurrencyItemLayoutBinding
import com.example.presentation.model.CurrencyBuyingRatePresentation

class CurrencyBuyingRateAdapter:RecyclerView.Adapter<CurrencyBuyingRateAdapter.ViewHolder>() {

    private val mutableBuyingRates = mutableListOf<CurrencyBuyingRatePresentation>()

    class ViewHolder(binding: CurrencyItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  ViewHolder(
        CurrencyItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        CurrencyItemLayoutBinding.bind(holder.itemView).bindWith(mutableBuyingRates[position])
    }

    override fun getItemCount(): Int = mutableBuyingRates.size

    fun addAllCurrencyBuyingRates(buyingRates:Collection<CurrencyBuyingRatePresentation>){
        mutableBuyingRates.addAll(buyingRates)
    }

}