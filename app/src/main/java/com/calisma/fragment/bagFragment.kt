package com.calisma.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.calisma.R
import com.calisma.databinding.FragmentBagBinding
import java.text.DecimalFormat


class bagFragment : Fragment() {

    lateinit var binding: FragmentBagBinding
    var image = ""
    var title = ""
    var price = 0.0
    var tempprice = 0.0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBagBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        val pref:SharedPreferences = requireActivity().getSharedPreferences("db",Context.MODE_PRIVATE)
        var control = pref.getString("controlsheet","").toString()
        if (control == "1") {
            val bundle:bagFragmentArgs by navArgs()
            image = bundle.image
            title = bundle.title
            price = bundle.price.toDouble()
            tempprice = price
            binding.bagPrice.text = "$$price"
            binding.bagtitle.text = title
            binding.bagTotalAmountText.text = "$$price"
            Glide.with(requireContext()).load(image).into(binding.bagimageView)
            pref.edit().putString("controlsheet","0").apply()
        }else {
            binding.bagBlok.visibility = View.INVISIBLE
            binding.editTextTextPersonName.visibility = View.INVISIBLE
            binding.imageView13.visibility = View.INVISIBLE
            binding.textView9.visibility = View.INVISIBLE
            binding.bagTotalAmountText.visibility = View.INVISIBLE
            binding.bagCheckOutBtn.visibility = View.INVISIBLE

            binding.noitemcardBag.visibility = View.VISIBLE
        }

        binding.bagupBtn.setOnClickListener {
            var number = binding.textView12.text.toString().toInt()
            number += 1
            binding.textView12.text = number.toString()
            tempprice += price
            val p = DecimalFormat("##.##").format(tempprice)
            binding.bagPrice.text = "$$p"
            binding.bagTotalAmountText.text = "$$p"
        }
        binding.bagdownBtn.setOnClickListener {
            var number = binding.textView12.text.toString().toInt()
            number -= 1
            binding.textView12.text = number.toString()
            tempprice -= price
            val p = DecimalFormat("##.##").format(tempprice)
            binding.bagPrice.text = "$$p"
            binding.bagTotalAmountText.text = "$$p"
        }
        binding.bagCheckOutBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.successFragment)
        }
        binding.loginBackBtn2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeFragment2)
        }
        return binding.root
    }


}