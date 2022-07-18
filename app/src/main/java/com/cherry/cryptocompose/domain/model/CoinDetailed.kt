package com.cherry.cryptocompose.domain.model

import com.google.gson.annotations.SerializedName

data class CoinDetailed(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("rank") val rank: Int,
    @SerializedName("is_active") val isActive: Boolean,
    @SerializedName("type") val type: String,
    @SerializedName("description") val description: String,
    @SerializedName("started_at") val startedAt: String? = null,
    @SerializedName("development_status") val developmentStatus: String
){
    val date: String?
    get() = startedAt?.substring(0,10)
}
