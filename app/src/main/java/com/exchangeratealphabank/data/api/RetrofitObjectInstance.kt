package com.exchangeratealphabank.data.api

import com.exchangeratealphabank.data.repository.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObjectInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: Api by lazy {
        retrofit.create(Api::class.java)
    }
}