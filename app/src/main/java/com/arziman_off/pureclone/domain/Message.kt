package com.arziman_off.pureclone.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(
    val senderId: Int,
    val receiverId: Int,
    val msgText: String
    // добавить аргументы в будущем
): Parcelable