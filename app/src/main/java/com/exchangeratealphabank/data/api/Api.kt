package com.exchangeratealphabank.data.api

import android.util.Log
import com.exchangeratealphabank.data.repository.ratesAlphaBank
import com.exchangeratealphabank.data.repository.ratesNationalBank
import com.exchangeratealphabank.models.AlphaBank.DataAlpha
import com.exchangeratealphabank.models.NationalBank.DataNational
import com.exchangeratealphabank.presentation.TAGExchangeRate
import retrofit2.http.GET

interface Api {
    @GET(ratesAlphaBank)
    suspend fun getAlpha(): DataAlpha

    @GET(ratesNationalBank)
    suspend fun getNational(): DataNational
}