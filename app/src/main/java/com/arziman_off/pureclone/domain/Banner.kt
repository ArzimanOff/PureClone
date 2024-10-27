package com.arziman_off.pureclone.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Banner(
    val id: Int,
    val bannerText: String
): Parcelable