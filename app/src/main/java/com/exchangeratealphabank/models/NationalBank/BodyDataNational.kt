package com.exchangeratealphabank.models.NationalBank

import com.google.gson.annotations.SerializedName

data class BodyDataNational ( @SerializedName("code")val code: Int,
                              @SerializedName("date")val date: String,
                              @SerializedName("iso")val iso: String,
                              @SerializedName("name")val name: String?,
                              @SerializedName("quantity")val quantity: Int,
                              @SerializedName("rate")val rate: Double)