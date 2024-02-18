package com.example.testmission.data.model.request

import com.google.gson.annotations.SerializedName

data class AppRequest(
    @SerializedName("cat_id")
    val catId : Int
)