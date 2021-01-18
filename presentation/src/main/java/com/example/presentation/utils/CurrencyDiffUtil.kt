package com.example.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.presentation.model.CurrencyBuyingRatePresentation

open class CurrencyDiffUtil(
    private val oldList: List<CurrencyBuyingRatePresentation>,
    private val newList: MutableList<CurrencyBuyingRatePresentation>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newListSize]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}