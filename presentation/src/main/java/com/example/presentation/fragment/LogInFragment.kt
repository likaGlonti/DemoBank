package com.example.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.presentation.R
import com.example.presentation.databinding.LogInFragmentBinding
import com.example.presentation.utils.showErrorDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.sign

@AndroidEntryPoint
class LogInFragment : Fragment(R.layout.log_in_fragment) {

    private val viewModel: LogInViewModel by viewModels()

    private lateinit var binding: LogInFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LogInFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onErrorLiveData.observe(viewLifecycleOwner, {
            showErrorDialog(resources.getString(R.string.error), it.message.toString())
        })

        viewModel.onCompleteLiveData.observe(viewLifecycleOwner, {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_logInFragment_to_currencyFragment2)
        })

        binding.apply {
            signUp.setOnClickListener {
                NavHostFragment.findNavController(this@LogInFragment)
                    .navigate(R.id.action_logInFragment_to_registrationFragment)
            }
            login.setOnClickListener {
                viewModel.logIn(
                    binding.logInEmailEt.text.toString(),
                    binding.passwordEt.text.toString(),
                )
            }
        }
    }
}