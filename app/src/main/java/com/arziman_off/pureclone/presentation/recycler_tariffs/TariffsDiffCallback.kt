package com.arziman_off.pureclone.presentation.recycler_tariffs

import androidx.recyclerview.widget.DiffUtil
import com.arziman_off.pureclone.domain.Tariff

class TariffsDiffCallback : DiffUtil.ItemCallback<Tariff>() {
    override fun areItemsTheSame(oldItem: Tariff, newItem: Tariff): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Tariff, newItem: Tariff): Boolean {
        return oldItem == newItem
    }
}