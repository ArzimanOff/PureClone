package com.arziman_off.pureclone.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ChatsListViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChatsListViewModel::class.java)){
            return ChatsListViewModel() as T
        }
        throw RuntimeException("Неверный тип передаваемого ViewModel")
    }
}