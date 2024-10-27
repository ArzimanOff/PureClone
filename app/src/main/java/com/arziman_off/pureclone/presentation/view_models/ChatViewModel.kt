package com.arziman_off.pureclone.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arziman_off.pureclone.domain.Message
import kotlin.random.Random

class ChatViewModel: ViewModel(
    // аргументы, если нужны
) {
    private val _messagesList= MutableLiveData<List<Message>>()
    val messagesList: LiveData<List<Message>>
        get() = _messagesList

    private val _cntOfTemptations= MutableLiveData<String>()
    val cntOfTemptations: LiveData<String>
        get() = _cntOfTemptations

    private val _toastMsg= MutableLiveData<Message>()
    val toastMsg: LiveData<Message>
        get() = _toastMsg


    init {
        loadChatInfo()
        loadCntOfTemptations()
    }

    private fun loadCntOfTemptations() {
        _cntOfTemptations.value = getFormatedNotifyText(
            Random.nextInt(1, 24)
        )
    }

    private fun loadChatInfo(){

    }

    fun sendTextMessage(message: Message){
        // TODO
        _toastMsg.value = message
    }

    private fun getFormatedNotifyText(count: Int): String {
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