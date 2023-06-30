package com.exchangeratealphabank.first_screen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exchangeratealphabank.data.repository.Repository
import com.exchangeratealphabank.models.AlphaBank.DataAlpha
import com.exchangeratealphabank.presentation.TAGExchangeRate
import kotlinx.coroutines.launch
class FirstViewModel:ViewModel() {
    private var repository = Repository()
    var alphaListLiveData: MutableLiveData<DataAlpha> = MutableLiveData()

    fun getRateAlpha() {
        viewModelScope.launch {
            Log.i(TAGExchangeRate, "FirstViewModel:getRateAlpha: полученние данных курса альфа-банка в пустой лист")
            //alphaListLiveData - объект класса livedata, который хранит значения <string>
            alphaListLiveData.value= repository.getRateAlpha()
            Log.i(TAGExchangeRate, "полученные данные курса Альфа-банка ${alphaListLiveData.value.toString()}")
        }
    }
}