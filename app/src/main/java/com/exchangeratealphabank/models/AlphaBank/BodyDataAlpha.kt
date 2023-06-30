package com.exchangeratealphabank.models.AlphaBank

import com.google.gson.annotations.SerializedName

data class BodyDataAlpha (@SerializedName("buyCode")val buyCode: Int,
                          @SerializedName("buyIso")val buyIso: String,
                          @SerializedName("buyRate") val buyRate: Double,
                          @SerializedName("date")val date: String,
                          @SerializedName("name")val name: String,
                          @SerializedName("quantity")val quantity: Int,
                          @SerializedName("sellCode")val sellCode: Int,
                          @SerializedName("sellIso") val sellIso: String,
                          @SerializedName("sellRate") val sellRate: Double)

/*
sellrate - курс покупки
selliso - какая валюта
buyrate - курс продажи
buyiso - к какой валюте
*/