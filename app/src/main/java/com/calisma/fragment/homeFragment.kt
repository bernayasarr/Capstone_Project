package com.calisma.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.calisma.R
import com.calisma.databinding.FragmentHomeBinding
import com.calisma.homeclass.liste_adapter
import com.calisma.utils.Instance
import com.calisma.utils.data
import com.calisma.utils.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class homeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: liste_adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)




        dataget()

        binding.loginBackBtn4.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeFragment2)
        }


        return binding.root
    }




    private fun dataget() {
        var list = arrayListOf<data>()
        Instance.getInstance().create(ApiService::class.java).getProducts()
            .enqueue(object : Callback<ArrayList<data>> {
                override fun onResponse(
                    call: Call<ArrayList<data>>,
                    response: Response<ArrayList<data>>
                ) {
                    if (response.isSuccessful) {
                        list = response.body()!!
                        adapter= liste_adapter(list)
                        val layoutManager = LinearLayoutManager(requireContext())
                        binding.homeRv.layoutManager = layoutManager
                        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                        binding.homeRv.adapter = adapter
                    }
                    else{
                    }
                }

                override fun onFailure(call: Call<ArrayList<data>>, t: Throwable) {

                }

            })
    }


}