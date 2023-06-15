package com.strength.internetconectionproject.network

import com.squareup.moshi.Json

data class MarsData(
    val id: Long,
    val price: Double,
    @Json(name="img_src") val imageSourceUrl: String,
    val type: String
)