package com.exchangeratealphabank.second_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.exchangeratealphabank.R
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val viewModelSecond = ViewModelProvider(this)[SecondViewModel::class.java]
        val recycler = view.recycler_second
        val adapter = SecondAdapterRecycler()
        recycler.adapter = adapter
        viewModelSecond.getRateNational()
        //getRateNational получает данные, которые надо уложить в список
        //методом observe подписываемся на изменения
        viewModelSecond.nationalListLiveData.observe(viewLifecycleOwner) { listRate ->
            listRate.body()?.let { adapter.setListNational(it.rate) }
        }
        return view
    }
}