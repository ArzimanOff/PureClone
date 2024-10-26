package com.arziman_off.pureclone.presentation.recycler_chats

import com.arziman_off.pureclone.domain.UserChat

interface ChatClickListener {
    fun onChatClick(userChat: UserChat)
}
