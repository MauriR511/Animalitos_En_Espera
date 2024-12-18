package com.rosales.adoptame.network.dto

import com.google.gson.annotations.SerializedName
import com.rosales.adoptame.data.model.Service

data class ServiceCardResponse (

    @SerializedName("count")
    val count:Int,
    @SerializedName("services")
    val services:List<Service>

)