package com.example.presentation.fragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.presentation.R
import com.example.presentation.activity.AuthActivity
import com.example.presentation.databinding.RegistrationFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class RegistrationFragment : Fragment(R.layout.registration_fragment) {

    private val viewModel: RegistrationViewModel by activityViewModels()

    private lateinit var binding: RegistrationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegistrationFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            birthDateEt.setOnClickListener {
                val calendar = Calendar.getInstance()
                val date = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, month)
                    calendar.set(Calendar.DATE, dayOfMonth)
                    birthDateEt.setText("$year/$month/$dayOfMonth")

                }
                DatePickerDialog(
                    (activity as AuthActivity),
                    date,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.MONTH)
                ).show()
            }
            goOnRegistration.setOnClickListener {
                viewModel.getName(binding.nameEt.text.toString())
                viewModel.getLastName(binding.lastNameEt.text.toString())
                viewModel.getEmail(binding.registerEmailEt.text.toString())
                viewModel.getBirthDate(binding.birthDateEt.text.toString())
                NavHostFragment.findNavController(this@RegistrationFragment)
                    .navigate(R.id.action_registrationFragment_to_nextPartRegistrationFragment)
            }
        }
    }
}