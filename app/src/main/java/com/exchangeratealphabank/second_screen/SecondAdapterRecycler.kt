package com.exchangeratealphabank.second_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exchangeratealphabank.databinding.ListViewBinding
import com.exchangeratealphabank.models.NationalBank.BodyDataNational

class SecondAdapterRecycler: RecyclerView.Adapter<SecondAdapterRecycler.ViewHolder>() {

    private var listItem = emptyList<BodyDataNational>()
    private lateinit var binding: ListViewBinding

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.currencyFirst.text = listItem[position].iso
        binding.rateBuy.text = listItem[position].rate.toString()
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListNational(list: List<BodyDataNational>) {
        listItem = list
        notifyDataSetChanged()
    }
}