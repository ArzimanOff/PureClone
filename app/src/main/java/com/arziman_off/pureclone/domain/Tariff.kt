package com.arziman_off.pureclone.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tariff(
    val id: Int,
    val cnt: Int,
    val cost: Int,
    val highlighting: Boolean,
    val highlightingText: String
): Parcelable