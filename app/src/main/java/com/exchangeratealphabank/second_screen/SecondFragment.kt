package com.exchangeratealphabank.second_screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.exchangeratealphabank.databinding.FragmentSecondBinding

class SecondFragment:Fragment() {

    private val viewModelSecond by viewModels<SecondViewModel>()
    private lateinit var binding: FragmentSecondBinding
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
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(context))
        val recyclerFragmentSecond = binding.recyclerSecond
        recyclerFragmentSecond.layoutManager = LinearLayoutManager(ctx)
        val adapter = SecondAdapterRecycler()
        recyclerFragmentSecond.adapter = adapter
        viewModelSecond.getRateNational()
        //getRateNational получает данные, которые надо уложить в список
        //методом observe подписываемся на изменения
        viewModelSecond.nationalListLiveData.observe(viewLifecycleOwner) { listRate ->
            listRate?.let { adapter.setListNational(it.rate) }
        }
        return binding.root
    }
}