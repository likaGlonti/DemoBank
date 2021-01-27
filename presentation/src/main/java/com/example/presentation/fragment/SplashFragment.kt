package com.example.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.presentation.R
import com.example.presentation.databinding.SplashFragmentBinding
import com.example.presentation.utils.delayed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.splash_fragment) {

    private val viewModel: CurrencyViewModel by activityViewModels()

    private lateinit var binding: SplashFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SplashFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onErrorLiveData.observe(viewLifecycleOwner, {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_splashFragment_to_logInFragment)
        })
        viewModel.onCompleteLiveData.observe(viewLifecycleOwner, {
            {
                NavHostFragment.findNavController(this)
                    .navigate(R.id.action_splashFragment_to_currencyFragment)
            }.delayed(1000)
        })
    }
}