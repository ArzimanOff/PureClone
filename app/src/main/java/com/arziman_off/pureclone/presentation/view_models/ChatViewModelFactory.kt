package com.arziman_off.pureclone.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ChatViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChatViewModel::class.java)){
            return ChatViewModel() as T
        }
        throw RuntimeException("Неверный тип передаваемого ViewModel")
    }
}