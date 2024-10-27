package com.arziman_off.pureclone.presentation.recycler_tariffs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.domain.Tariff

class TariffsAdapter(): ListAdapter<Tariff, TariffsViewHolder>(TariffsDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TariffsViewHolder {
        val res = R.layout.item_tariff
        val view = LayoutInflater.from(parent.context).inflate(
            res,
            parent,
            false
        )
        return TariffsViewHolder(view)
    }


    override fun onBindViewHolder(holder: TariffsViewHolder, position: Int) {
        val tariff = getItem(position)
        holder.cnt.text = tariff.cnt.toString()
        holder.cost.text = String.format("${tariff.cost} ₽")
        if (tariff.highlighting){
            holder.tariff_highlight.visibility = View.VISIBLE
            holder.tariff_highlight.text = tariff.highlightingText
        } else {
            holder.tariff_highlight.visibility = View.GONE
        }
    }
}