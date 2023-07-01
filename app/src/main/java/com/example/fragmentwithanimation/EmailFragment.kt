package com.example.fragmentwithanimation

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fragmentwithanimation.databinding.FragmentEmailBinding


class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmailBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
            if(!TextUtils.isEmpty(binding.etEmail.text.toString())){
                if(Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()){
                    val input_name = requireArguments().getString("user_name")
                    val bundle = bundleOf("user_name" to input_name, "user_email" to binding.etEmail.text.toString())
                    it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
                }else{
                    Toast.makeText(activity, "Please enter correct email", Toast.LENGTH_SHORT).show()
                }
            }else {
                Toast.makeText(activity, "Please enter a email", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}