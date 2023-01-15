package com.exchangeratealphabank.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObjectInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://developerhub.alfabank.by:8273/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: Api by lazy {
        retrofit.create(Api::class.java)
    }
}