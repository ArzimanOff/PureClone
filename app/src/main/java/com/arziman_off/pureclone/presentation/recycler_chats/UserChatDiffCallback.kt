package com.arziman_off.pureclone.presentation.recycler_chats

import androidx.recyclerview.widget.DiffUtil
import com.arziman_off.pureclone.domain.UserChat

class UserChatDiffCallback: DiffUtil.ItemCallback<UserChat>() {
    override fun areItemsTheSame(oldItem: UserChat, newItem: UserChat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserChat, newItem: UserChat): Boolean {
        return oldItem == newItem
    }
}