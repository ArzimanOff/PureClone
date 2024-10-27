package com.arziman_off.pureclone.data


import com.arziman_off.pureclone.domain.UserChat
import kotlin.random.Random

object ChatsListGenerator {
    private val avatars = listOf(
        "https://randomuser.me/api/portraits/men/1.jpg",
        "https://randomuser.me/api/portraits/women/2.jpg",
        "https://randomuser.me/api/portraits/men/3.jpg",
        "https://randomuser.me/api/portraits/women/4.jpg",
        "https://randomuser.me/api/portraits/men/5.jpg",
        "https://randomuser.me/api/portraits/women/6.jpg",
        "https://randomuser.me/api/portraits/men/7.jpg",
        "https://randomuser.me/api/portraits/women/8.jpg",
        "https://randomuser.me/api/portraits/men/9.jpg",
        "https://randomuser.me/api/portraits/women/10.jpg",
        "https://randomuser.me/api/portraits/men/11.jpg",
        "https://randomuser.me/api/portraits/women/12.jpg"
        // Добавьте больше ссылок на аватарки
    )

    private val messages = listOf(
        "Привет! Как дела?",
        "Ты скоро будешь?",
        "Уже подъезжаю!",
        "Как прошло совещание?",
        "Завтра встречаемся?"
    )

    // Метод для генерации списка случайных чатов
    fun generateChats(count: Int): List<UserChat> {
        val chats = mutableListOf<UserChat>()
        for (i in 1..count) {
            chats.add(
                UserChat(
                    id = i,
                    avatarUrl = avatars.random(),
                    lastMessageTime = "${Random.nextInt(1, 24)} ч. назад",
                    lastMessage = messages.random(),
                    isMessageRead = Random.nextBoolean()
                )
            )
        }
        return chats
    }
}
