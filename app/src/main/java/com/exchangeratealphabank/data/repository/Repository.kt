package com.exchangeratealphabank.data.repository

import android.util.Log
import com.exchangeratealphabank.data.api.RetrofitObjectInstance
import com.exchangeratealphabank.models.AlphaBank.DataAlpha
import com.exchangeratealphabank.models.NationalBank.DataNational
import com.exchangeratealphabank.presentation.TAGExchangeRate

const val BASE_URL = "https://developerhub.alfabank.by:8273/"
const val ratesAlphaBank = "partner/1.0.1/public/rates"
const val ratesNationalBank = "partner/1.0.1/public/nationalRates?currencyCode=840,978"
class Repository {

    suspend fun getRateAlpha(): DataAlpha {
        Log.i(TAGExchangeRate, "Repository.getRateAlpha: запрос в сеть АльфаКурс")
        Log.i(TAGExchangeRate, "Repository.getRateAlpha: ответ JSON ${RetrofitObjectInstance.api.getAlpha()}")
        return RetrofitObjectInstance.api.getAlpha()
    }

    suspend fun getRateNational(): DataNational {
        Log.i(TAGExchangeRate, "запрос в сеть Национальный курс")
        return RetrofitObjectInstance.api.getNational()
    }
}