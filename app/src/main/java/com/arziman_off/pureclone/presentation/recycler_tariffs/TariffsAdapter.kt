package com.arziman_off.pureclone.presentation.recycler_tariffs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.domain.Tariff

class TariffsAdapter(
    private val onTariffSelected: (Tariff) -> Unit
): ListAdapter<Tariff, TariffsViewHolder>(TariffsDiffCallback()) {
    private var selectedPosition = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TariffsViewHolder {
        val res = R.layout.item_tariff
        val view = LayoutInflater.from(parent.context).inflate(
            res,
            parent,
            false
        )
        return TariffsViewHolder(view)
    }

    fun getTariff() = getItem(selectedPosition)


    override fun onBindViewHolder(holder: TariffsViewHolder, position: Int) {
        val tariff = getItem(position)
        holder.cnt.text = tariff.cnt.toString()
        holder.cost.text = String.format("${tariff.cost} ₽")
        if (selectedPosition == position) {
            holder.tariff_content.setBackgroundResource(R.drawable.tariff_selected_bg)  // Выбранный тариф
        } else {
            holder.tariff_content.setBackgroundResource(R.drawable.tariff_default_bg)  // Невыбранный тариф
        }
        if (tariff.highlighting){
            holder.tariff_highlight.visibility = View.VISIBLE
            holder.tariff_highlight.text = tariff.highlightingText
        } else {
            holder.tariff_highlight.visibility = View.GONE
        }

        // Обработка клика на элемент
        holder.itemView.setOnClickListener {
            // Обновление позиции выбранного элемента
            val previousSelected = selectedPosition
            selectedPosition = holder.adapterPosition

            // Оповещаем адаптер о необходимости обновить два элемента: старый и новый выбранные
            notifyItemChanged(previousSelected)
            notifyItemChanged(selectedPosition)

            // Передаем выбранный тариф через callback
            onTariffSelected(tariff)
        }
    }
}