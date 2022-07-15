package com.calisma.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.calisma.R
import com.calisma.databinding.FragmentProfileBinding


class profileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        binding.loginBackBtn6.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeFragment2)
        }
        return binding.root
    }


}