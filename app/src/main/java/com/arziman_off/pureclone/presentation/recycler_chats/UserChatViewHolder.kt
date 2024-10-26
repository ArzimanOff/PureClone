package com.arziman_off.pureclone.presentation.recycler_chats

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arziman_off.pureclone.R
import de.hdodenhof.circleimageview.CircleImageView

class UserChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val avatar: CircleImageView = itemView.findViewById(R.id.profile_image)
    val lastMessageTime: TextView = itemView.findViewById(R.id.chatLastMessageTime)
    val lastMessage: TextView = itemView.findViewById(R.id.chatLastMessage)
    val readStatus: ImageView = itemView.findViewById(R.id.chatReadStatus)
}
