package com.example.smdassignment4.model

import com.google.gson.annotations.SerializedName

class Popular {
    @SerializedName("title")
    var title: String? = null
    @SerializedName("pic")
    var pic: String? = null
    @SerializedName("fees")
    var fees: Double? = null
}
