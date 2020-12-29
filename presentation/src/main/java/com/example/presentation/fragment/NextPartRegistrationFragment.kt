package com.example.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.presentation.R
import com.example.presentation.databinding.NextPartRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NextPartRegistrationFragment : Fragment(R.layout.next_part_registration) {

    private val viewModel:RegistrationViewModel by activityViewModels()

    private lateinit var binding: NextPartRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NextPartRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onCompleteLiveData.observe(viewLifecycleOwner, {
            if (it){
                NavHostFragment.findNavController(this@NextPartRegistrationFragment)
                    .navigate(R.id.action_nextPartRegistrationFragment_to_logInFragment)
            }
        })

        viewModel.onErrorLiveData.observe(viewLifecycleOwner, {
            println(it.message.toString())
        })

        binding.apply {
            signUp.setOnClickListener {
                viewModel.getPhoneNumber(phoneNumberEt.text.toString())
                viewModel.getPersonalId(personalIdEt.text.toString())
                viewModel.getAddress(addressEt.text.toString())
                viewModel.getPassword(passwordEt.text.toString())
                viewModel.getPasswordConfirmation(passwordConfirmationEt.text.toString())
                viewModel.registerAndNavigateToCurrency()
            }
        }
    }
}