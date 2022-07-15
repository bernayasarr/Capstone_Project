package com.calisma.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.calisma.R
import com.calisma.databinding.FragmentSuccessBinding


class successFragment : Fragment() {
    lateinit var binding : FragmentSuccessBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuccessBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        binding.continueBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeFragment2)
        }
        return binding.root
    }


}