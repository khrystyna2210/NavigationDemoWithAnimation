package com.example.fragmentwithanimation

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fragmentwithanimation.databinding.FragmentEmailBinding
import com.example.fragmentwithanimation.databinding.FragmentNameBinding


class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNameBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
            if(!TextUtils.isEmpty(binding.etName.text.toString())){
                val bundle = bundleOf("user_name" to binding.etName.text.toString())
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, bundle)
            }else {
                Toast.makeText(activity, "Please enter a name", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}