package com.arziman_off.pureclone.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arziman_off.pureclone.data.ChatGenerator
import com.arziman_off.pureclone.domain.UserChat

class ChatsViewModel: ViewModel(
    // аргументы, если нужны
) {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading
    private val _chatsList = MutableLiveData<List<UserChat>>()
    val chatsList: LiveData<List<UserChat>>
        get() = _chatsList
    init {
        loadChatsInfo()
        loadLikesCountInfo()
    }
    fun loadChatsInfo(){
        _isLoading.value = true
        //TODO сделать задержку, для имитации загрузки из сети
        _chatsList.value = ChatGenerator.generateChats(20)
        _isLoading.value = false
    }
    fun loadLikesCountInfo(){

    }
}