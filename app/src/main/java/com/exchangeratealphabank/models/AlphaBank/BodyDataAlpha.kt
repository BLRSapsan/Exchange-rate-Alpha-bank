package com.exchangeratealphabank.models.AlphaBank

data class BodyDataAlpha (val buyCode: Int,
                          val buyIso: String,
                          val buyRate: Double,
                          val date: String,
                          val name: String,
                          val quantity: Int,
                          val sellCode: Int,
                          val sellIso: String,
                          val sellRate: Double)

/*
sellrate - курс покупки
selliso - какая валюта
buyrate - курс продажи
buyiso - к какой валюте
*/