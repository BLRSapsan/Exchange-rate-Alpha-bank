package com.exchangeratealphabank.second_screen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.exchangeratealphabank.R
import com.exchangeratealphabank.presentation.TAGExchangeRate
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment:Fragment() {
    private var ctx:Context?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx=context
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val viewModelSecond = ViewModelProvider(this)[SecondViewModel::class.java]
        val recyclerFragmentSecond = view.recycler_second
        recyclerFragmentSecond.layoutManager = LinearLayoutManager(ctx)
        val adapter = SecondAdapterRecycler()
        recyclerFragmentSecond.adapter = adapter
        viewModelSecond.getRateNational()
        //getRateNational получает данные, которые надо уложить в список
        //методом observe подписываемся на изменения
        viewModelSecond.nationalListLiveData.observe(viewLifecycleOwner) { listRate ->
            listRate?.let { adapter.setListNational(it.rate) }
        }
        return view
    }
}