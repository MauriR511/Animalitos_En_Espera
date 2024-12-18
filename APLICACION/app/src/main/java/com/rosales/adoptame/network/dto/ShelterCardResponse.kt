package com.rosales.adoptame.network.dto

import com.google.gson.annotations.SerializedName
import com.rosales.adoptame.data.model.Shelter

class ShelterCardResponse (
    @SerializedName("count")
    val count:Int,
    @SerializedName("shelters")
    val shelters:List<Shelter>

)

