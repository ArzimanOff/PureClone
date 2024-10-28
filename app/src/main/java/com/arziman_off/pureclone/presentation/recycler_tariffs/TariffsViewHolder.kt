package com.arziman_off.pureclone.presentation.recycler_tariffs

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arziman_off.pureclone.R

class TariffsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val cost: TextView = itemView.findViewById(R.id.cost)
    val cnt: TextView = itemView.findViewById(R.id.cnt)
    val tariff_highlight: TextView = itemView.findViewById(R.id.tariff_highlight)
    val tariff_content: LinearLayout = itemView.findViewById(R.id.tariff_content)
}
