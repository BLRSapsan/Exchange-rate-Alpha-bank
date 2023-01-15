package com.exchangeratealphabank.data.api

import com.exchangeratealphabank.models.AlphaBank.DataAlpha
import com.exchangeratealphabank.models.NationalBank.DataNational
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("partner/1.0.1/public/rates")
    suspend fun getAlpha(): Response<DataAlpha>

    @GET("partner/1.0.1/public/nationalRates?currencyCode=840,978")
    suspend fun getNational(): Response<DataNational>
}