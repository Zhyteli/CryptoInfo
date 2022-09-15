package com.zhytel.cryptoinfo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Datum (
    @SerializedName("CoinInfo")
    @Expose
    val coinInfoDto: CoinInfoDto? = null
)
