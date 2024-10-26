package com.arziman_off.pureclone.domain

data class UserChat(
    val id: Int,
    val avatarUrl: String,
    val lastMessageTime: String,
    val lastMessage: String,
    val isMessageRead: Boolean
)
