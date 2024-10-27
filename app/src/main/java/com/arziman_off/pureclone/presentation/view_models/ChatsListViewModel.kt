package com.arziman_off.pureclone.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arziman_off.pureclone.data.ChatsListGenerator
import com.arziman_off.pureclone.domain.UserChat
import kotlin.random.Random

class ChatsListViewModel: ViewModel(
    // аргументы, если нужны
) {
    private val _chatListIsLoading = MutableLiveData<Boolean>()
    val chatListIsLoading: LiveData<Boolean>
        get() = _chatListIsLoading

    private val _likesCntIsLoading = MutableLiveData<Boolean>()
    val likesCntIsLoading: LiveData<Boolean>
        get() = _likesCntIsLoading

    private val _chatsList = MutableLiveData<List<UserChat>>()
    val chatsList: LiveData<List<UserChat>>
        get() = _chatsList

    private val _likesCntText = MutableLiveData<String>()
    val likesCntText: LiveData<String>
        get() = _likesCntText

    init {
        loadChatsInfo()
        loadLikesCountInfo()
    }
    fun loadChatsInfo(){
        _chatListIsLoading.value = true
        //TODO сделать задержку, для имитации загрузки из сети
        _chatsList.value = ChatsListGenerator.generateChats(20)
        _chatListIsLoading.value = false
    }
    fun loadLikesCountInfo(){
        _likesCntIsLoading.value = true
        //TODO сделать задержку, для имитации загрузки из сети
        _likesCntText.value = getFormatedLikesCntTex(Random.nextInt(1, 24))
        _likesCntIsLoading.value = false
    }

    private fun getFormatedLikesCntTex(count: Int): String {
        val peopleSuffix = when {
            count % 100 in 11..19 -> "человек"
            count % 10 == 1 -> "человек"
            count % 10 in 2..4 -> "человека"
            else -> "человек"
        }

        val postffix = when {
            count % 100 == 1 -> "лайкнул"
            else -> "лайкнуло"
        }

        return "$count $peopleSuffix тебя $postffix"
    }
}