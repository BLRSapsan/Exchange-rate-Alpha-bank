package com.exchangeratealphabank.second_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exchangeratealphabank.R
import com.exchangeratealphabank.models.NationalBank.BodyDataNational
import kotlinx.android.synthetic.main.list_view.view.*

class SecondAdapterRecycler: RecyclerView.Adapter<SecondAdapterRecycler.ViewHolder>() {
    private var listItem = emptyList<BodyDataNational>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.currency_first.text = listItem[position].iso
        holder.itemView.buy.text = listItem[position].rate.toString()
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