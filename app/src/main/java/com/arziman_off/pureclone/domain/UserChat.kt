package com.arziman_off.pureclone.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserChat(
    val id: Int,
    val avatarUrl: String,
    val lastMessageTime: String,
    val lastMessage: String,
    val isMessageRead: Boolean
): Parcelable