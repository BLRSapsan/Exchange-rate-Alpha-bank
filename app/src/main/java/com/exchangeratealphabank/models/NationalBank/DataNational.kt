package com.exchangeratealphabank.models.NationalBank

import com.google.gson.annotations.SerializedName

data class DataNational (@SerializedName("rates")val rate:List<BodyDataNational>)