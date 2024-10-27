package com.arziman_off.pureclone.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arziman_off.pureclone.data.CountOfTemptationsGenerator
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

    private val _messageIsSent= MutableLiveData<Boolean>()
    val messageIsSent: LiveData<Boolean>
        get() = _messageIsSent

    private val _toastMsg= MutableLiveData<Message>()
    val toastMsg: LiveData<Message>
        get() = _toastMsg


    init {
        loadChatInfo()
        loadCntOfTemptations()
    }

    private fun loadCntOfTemptations() {
        _cntOfTemptations.value = getFormatedNotifyText(
            CountOfTemptationsGenerator.generateCountOfTemptations()
        )
    }

    private fun loadChatInfo(){

    }

    fun sendTextMessage(message: Message){
        // TODO
        _toastMsg.value = message
        _messageIsSent.value = true
    }

    private fun getFormatedNotifyText(count: Int): String {

        val word = when {
            count % 100 in 11..19 -> "общих"
            count % 10 == 1 -> "общий"
            else -> "общих"
        }

        val suffix = when {
            count % 100 in 11..19 -> "соблазнов"
            count % 10 == 1 -> "соблазн"
            count % 10 in 2..4 -> "соблазна"
            else -> "соблазнов"
        }

        return "$count $word $suffix"
    }
}