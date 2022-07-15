package com.calisma.utils

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("get_products.php")
    fun getProducts(): Call<ArrayList<data>>



}