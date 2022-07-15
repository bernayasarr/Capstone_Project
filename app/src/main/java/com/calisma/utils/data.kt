package com.calisma.utils



import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class data (

    @SerializedName("id")
    var id: Int,

    @SerializedName("user")
    var user: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("price")
    var price: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("category")
    var category: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("image_two")
    var image2: String,

    @SerializedName("image_three")
    var image3: String,

    @SerializedName("rate")
    var rate: String,

    @SerializedName("count")
    var count: Int,

    @SerializedName("saleState")
    var saleState: Int

):Serializable
