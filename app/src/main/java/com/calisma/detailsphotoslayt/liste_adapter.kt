package com.calisma.detailsphotoslayt

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.calisma.R


class liste_adapter(private val mContext:Context, private val liste:List<liste>)
    :RecyclerView.Adapter<liste_adapter.cardtasarimtutucu>(){

    inner class cardtasarimtutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim){
        var image:ImageView

        init {
            image = tasarim.findViewById(R.id.detailrvImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardtasarimtutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.design_home_details_rv,parent,false)

        return cardtasarimtutucu(tasarim)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: cardtasarimtutucu, position: Int) {
        val list = liste[position]
        Glide.with(mContext).load(list.image).placeholder(R.drawable.image).into(holder.image)


    }
    override fun getItemCount(): Int {
        return liste.size
    }
}