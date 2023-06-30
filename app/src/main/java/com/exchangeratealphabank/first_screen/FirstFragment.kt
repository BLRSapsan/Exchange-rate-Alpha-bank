package com.exchangeratealphabank.first_screen

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
import com.exchangeratealphabank.models.AlphaBank.DataAlpha
import com.exchangeratealphabank.presentation.TAGExchangeRate
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment:Fragment() {
    private var ctx: Context? = null
   override fun onAttach(context: Context) {
       super.onAttach(context)
       ctx = context
   }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModelFirst = ViewModelProvider(this)[FirstViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val recyclerFragmentFirst = view.recycler_first
        recyclerFragmentFirst.layoutManager= LinearLayoutManager(ctx)
        val adapterRecycler = FirstAdapterRecycler()
        recyclerFragmentFirst.adapter = adapterRecycler
        viewModelFirst.getRateAlpha()
        Log.i(TAGExchangeRate, "viewModelFirst.getRateAlpha()\n")
        //getRateAlpha получает данные, которые надо уложить в список
        //методом observe подписываемся на изменения
        viewModelFirst.alphaListLiveData.observe(viewLifecycleOwner) { listRate ->
            Log.i(TAGExchangeRate, "FirstFragment: observe на список")
            Log.i(TAGExchangeRate, "ListRate записанные данные = ${listRate.rate}")
            listRate.let { adapterRecycler.setListAlpha(it.rate) }
        }
        return view
    }
}