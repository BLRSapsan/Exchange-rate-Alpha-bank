package com.exchangeratealphabank.models.NationalBank

data class BodyDataNational ( val code: Int,
                              val date: String,
                              val iso: String,
                              val name: String,
                              val quantity: Int,
                              val rate: Double)