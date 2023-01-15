package com.exchangeratealphabank.first_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exchangeratealphabank.data.repository.Repository
import com.exchangeratealphabank.models.AlphaBank.DataAlpha
import kotlinx.coroutines.launch
import retrofit2.Response

class FirstViewModel:ViewModel() {
    private var repository = Repository()
    val alphaListLiveData: MutableLiveData<Response<DataAlpha>> = MutableLiveData()
    fun getRateAlpha() {
        viewModelScope.launch {
            //alphaListLiveData - объект класса livedata, который хранит значения <string>
            alphaListLiveData.value = repository.getRateAlpha()
        }
    }
}