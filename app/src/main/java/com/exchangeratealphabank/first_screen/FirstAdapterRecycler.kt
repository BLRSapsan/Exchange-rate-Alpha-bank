package com.exchangeratealphabank.first_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exchangeratealphabank.R
import com.exchangeratealphabank.models.AlphaBank.BodyDataAlpha
import kotlinx.android.synthetic.main.list_view.view.*

internal class FirstAdapterRecycler: RecyclerView.Adapter<FirstAdapterRecycler.ViewHolder>() {

    private var listDataAlpha = emptyList<BodyDataAlpha>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false)
        return ViewHolder(view = view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.currency_first.text = listDataAlpha[position].sellIso
        holder.itemView.currency_second.text = listDataAlpha[position].buyIso
        holder.itemView.rate_buy.text = listDataAlpha[position].sellRate.toString()
        holder.itemView.rate_sale.text = listDataAlpha[position].buyRate.toString()
    }

    override fun getItemCount(): Int {
        return listDataAlpha.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListAlpha(setList: List<BodyDataAlpha>) {
        listDataAlpha = setList
        notifyDataSetChanged()
    }
}