package com.example.fragmentwithanimation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fragmentwithanimation.databinding.FragmentTermBinding
import com.example.fragmentwithanimation.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        val input_name = requireArguments().getString("user_name")
        binding.tvName.text = input_name
        val input_email = requireArguments().getString("user_email")
        binding.tvEmail.text = input_email

        binding.btnTerms.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_termFragment)
        }

        return binding.root
    }
}