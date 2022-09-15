package com.zhytel.cryptoinfo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.zhytel.cryptoinfo.data.model.Datum

data class CoinInfoListOfData (
    @SerializedName("Data")
    @Expose
    val data: List<Datum>? = null
)
