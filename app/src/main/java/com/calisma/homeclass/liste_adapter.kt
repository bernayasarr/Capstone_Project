package com.calisma.homeclass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.calisma.databinding.DesignHomeRvBinding
import com.calisma.fragment.homeFragmentDirections
import com.calisma.utils.data


class liste_adapter(var liste: List<data>) : RecyclerView.Adapter<Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DesignHomeRvBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val list = liste[position]
        holder.binding.apply {
            designHomeName.text = list.title
            designHomePrice.text = "$" + list.price
            Glide.with(this.root).load(list.image).into(designhomeimageView)
            designCard.setOnClickListener {
                val gecis = homeFragmentDirections.actionHomeFragment2ToHomeFragmentDetails(list)
                Navigation.findNavController(it).navigate(gecis)
            }
        }
    }

    override fun getItemCount(): Int {
        return liste.size
    }
}


class Holder(val binding: DesignHomeRvBinding) :
    RecyclerView.ViewHolder(binding.root)