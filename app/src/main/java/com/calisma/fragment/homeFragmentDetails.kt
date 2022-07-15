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
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.calisma.R
import com.calisma.databinding.FragmentHomeDetailsBinding
import com.calisma.detailsphotoslayt.liste
import com.calisma.detailsphotoslayt.liste_adapter


class homeFragmentDetails : Fragment() {
    lateinit var binding: FragmentHomeDetailsBinding
    private lateinit var liste : ArrayList<liste>
    private lateinit var adapter : liste_adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeDetailsBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        val bundle:homeFragmentDetailsArgs by navArgs()
        val inputdata = bundle.nesne

        val title= inputdata.title
        val price= inputdata.price
        val category = inputdata.category
        val rate = inputdata.rate
        val description = inputdata.description


        //Array
        var image = inputdata.image
        val image2 = inputdata.image2
        val image3 = inputdata.image3

        binding.homeDetayHeaderText.text = category
        binding.detailTitleModel.text = title
        binding.detailtitlesub.text = category
        binding.detailratingText.text = "($rate)"
        binding.detaildescriptionText.text = description
        binding.detailprices.text = "$$price"

        binding.detailrv.setHasFixedSize(true)
        val lm = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.detailrv.layoutManager = lm
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(binding.detailrv)
        liste = ArrayList()
        adapter = liste_adapter(requireContext(),liste)
        binding.detailrv.adapter = adapter

        liste.clear()
        liste.add(liste("1", image))
        liste.add(liste("2",image2))
        liste.add(liste("3",image3))
        adapter.notifyDataSetChanged()

        val pref:SharedPreferences = requireActivity().getSharedPreferences("db",Context.MODE_PRIVATE)

        binding.detailsaddtoCardBtn.setOnClickListener {
            pref.edit().putString("controlsheet","1").apply()
            val gecis = homeFragmentDetailsDirections.actionHomeFragmentDetailsToBagFragment(title,price,image)
            Navigation.findNavController(it).navigate(gecis)
        }
        binding.loginBackBtn5.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeFragment2)
        }

        return binding.root
    }


}