package com.example.presentation.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.adapter.CurrencyBuyingRateAdapter
import com.example.presentation.databinding.CurrencyFragmentBinding
import com.example.presentation.utils.showErrorDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyFragment : Fragment(R.layout.currency_fragment) {

    private val viewModel: CurrencyViewModel by viewModels()

    private lateinit var binding: CurrencyFragmentBinding

    private lateinit var buyingRateAdapter: CurrencyBuyingRateAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CurrencyFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buyingRateAdapter = CurrencyBuyingRateAdapter()

        binding.apply {
            currencyBuyRateRecyclerView.adapter = buyingRateAdapter
            currencyBuyRateRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        viewModel.currencyBuyingRateLiveData.observe(viewLifecycleOwner, {
            buyingRateAdapter.addAllCurrencyBuyingRates(it)
        })

        viewModel.onErrorLiveData.observe(viewLifecycleOwner, {
            showErrorDialog(resources.getString(R.string.error), it.message.toString())
        })
    }
}