package com.example.smdassignment4.model

import com.google.gson.annotations.SerializedName

class ApiResponse {
    @SerializedName("categoryData")
    var categoryData: List<Category> = ArrayList()

    @SerializedName("popularData")
    var popularData: List<Popular> = ArrayList()
}