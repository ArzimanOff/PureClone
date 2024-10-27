package com.arziman_off.pureclone.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class CustomBottomSheetViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomBottomSheetViewModel::class.java)){
            return CustomBottomSheetViewModel() as T
        }
        throw RuntimeException("Неверный тип передаваемого ViewModel")
    }
}