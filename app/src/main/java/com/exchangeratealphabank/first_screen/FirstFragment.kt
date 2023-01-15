package com.exchangeratealphabank.first_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.exchangeratealphabank.R
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val viewModelFirst = ViewModelProvider(this)[FirstViewModel::class.java]
        val recycler = view.recycler_first
        val adapterRecycler = FirstAdapterRecycler()
        recycler.adapter = adapterRecycler
        viewModelFirst.getRateAlpha()

        //getRateAlpha получает данные, которые надо уложить в список
        //методом observe подписываемся на изменения
        viewModelFirst.alphaListLiveData.observe(viewLifecycleOwner) { listRate ->
            listRate.body()?.let { adapterRecycler.setListAlpha(it.rate) }
        }
        return view
    }
}