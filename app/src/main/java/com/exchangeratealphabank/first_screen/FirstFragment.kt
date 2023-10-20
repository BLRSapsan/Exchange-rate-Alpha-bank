package com.exchangeratealphabank.first_screen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.exchangeratealphabank.databinding.FragmentFirstBinding
import com.exchangeratealphabank.presentation.TAGExchangeRate

class FirstFragment:Fragment() {

    private lateinit var bindingFirstFragment: FragmentFirstBinding
    private val viewModelFirst by viewModels<FirstViewModel>()
    private var ctx: Context? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingFirstFragment = FragmentFirstBinding.inflate(LayoutInflater.from(context))
        val recyclerFragmentFirst = bindingFirstFragment.recyclerFirst
        val adapterRecycler = FirstAdapterRecycler()
        recyclerFragmentFirst.layoutManager = LinearLayoutManager(ctx)
        recyclerFragmentFirst.adapter = adapterRecycler
        viewModelFirst.getRateAlpha()
        //getRateAlpha получает данные, которые надо уложить в список
        //методом observe подписываемся на изменения
        viewModelFirst.alphaListLiveData.observe(viewLifecycleOwner) { listRate ->
            Log.i(TAGExchangeRate, "FirstFragment: observe на список")
            Log.i(TAGExchangeRate, "ListRate записанные данные = ${listRate.rate}")
            listRate.let { adapterRecycler.setListAlpha(it.rate) }
        }
        return bindingFirstFragment.root
    }
}