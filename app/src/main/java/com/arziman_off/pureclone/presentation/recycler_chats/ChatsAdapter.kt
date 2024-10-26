package com.arziman_off.pureclone.presentation.recycler_chats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.domain.UserChat
import com.bumptech.glide.Glide


class ChatsAdapter(
    private val listener: ChatClickListener
): ListAdapter<UserChat, UserChatViewHolder>(UserChatDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserChatViewHolder {
        val res = R.layout.item_chat
        val view = LayoutInflater.from(parent.context).inflate(
            res,
            parent,
            false
        )
        return UserChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserChatViewHolder, position: Int) {
        val userChat = getItem(position)
        holder.lastMessageTime.text = userChat.lastMessageTime
        holder.lastMessage.text = userChat.lastMessage

        Glide.with(holder.itemView.context)
            .load(userChat.avatarUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(holder.avatar)

        // Устанавливаем обработчик клика
        holder.itemView.setOnClickListener {
            listener.onChatClick(userChat)  // Вызываем метод интерфейса, передавая выбранный чат
        }

        holder.readStatus.visibility = if (userChat.isMessageRead) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }
}
