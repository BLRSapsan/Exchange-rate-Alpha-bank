package com.exchangeratealphabank.data.repository

import com.exchangeratealphabank.data.api.RetrofitObjectInstance
import com.exchangeratealphabank.models.AlphaBank.DataAlpha
import com.exchangeratealphabank.models.NationalBank.DataNational
import retrofit2.Response

class Repository {

    suspend fun getRateAlpha(): Response<DataAlpha> {
        return RetrofitObjectInstance.api.getAlpha()
    }

    suspend fun getRateNational(): Response<DataNational> {
        return RetrofitObjectInstance.api.getNational()
    }
}