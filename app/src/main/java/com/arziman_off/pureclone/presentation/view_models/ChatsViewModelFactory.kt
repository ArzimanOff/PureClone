package com.arziman_off.pureclone.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ChatsViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChatsViewModel::class.java)){
            return ChatsViewModel() as T
        }
        throw RuntimeException("Неверный тип передаваемого ViewModel")
    }
}