package com.exchangeratealphabank.second_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exchangeratealphabank.data.repository.Repository
import com.exchangeratealphabank.models.NationalBank.DataNational
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel:ViewModel() {
    private var repository = Repository()
    var nationalListLiveData: MutableLiveData<DataNational> = MutableLiveData()

    fun getRateNational() {
        viewModelScope.launch {
            //nationalListLiveData - объект класса livedata, который хранит значения <string>
            nationalListLiveData.value = repository.getRateNational()
        }
    }
}