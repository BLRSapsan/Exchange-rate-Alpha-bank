package com.exchangeratealphabank.first_screen

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exchangeratealphabank.databinding.ListViewBinding
import com.exchangeratealphabank.models.AlphaBank.BodyDataAlpha
import com.exchangeratealphabank.presentation.TAGExchangeRate

internal class FirstAdapterRecycler: RecyclerView.Adapter<FirstAdapterRecycler.ViewHolder>() {

    private var listDataAlpha = emptyList<BodyDataAlpha>()
    private lateinit var bindingFirstAdapter: ListViewBinding

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        bindingFirstAdapter =
            ListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bindingFirstAdapter.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindingFirstAdapter.currencyFirst.text = listDataAlpha[position].sellIso
        bindingFirstAdapter.currencySecond.text = listDataAlpha[position].buyIso
        bindingFirstAdapter.rateBuy.text = listDataAlpha[position].sellRate.toString()
        bindingFirstAdapter.rateSale.text = listDataAlpha[position].buyRate.toString()
    }

    override fun getItemCount(): Int {
        return listDataAlpha.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListAlpha(setList: List<BodyDataAlpha>) {
        Log.i(TAGExchangeRate, "FirstAdapterRecycler: передача данных в setListAlpha")
        listDataAlpha = setList
        notifyDataSetChanged()
    }
}