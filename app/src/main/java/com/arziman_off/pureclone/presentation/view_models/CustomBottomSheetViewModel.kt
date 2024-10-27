package com.arziman_off.pureclone.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arziman_off.pureclone.data.ChatsListGenerator
import com.arziman_off.pureclone.data.CountOfLikesGenerator
import com.arziman_off.pureclone.data.TariffGenerator
import com.arziman_off.pureclone.domain.Tariff
import com.arziman_off.pureclone.domain.UserChat
import kotlin.random.Random

class CustomBottomSheetViewModel: ViewModel(
    // аргументы, если нужны
) {
    private val _tariffsList = MutableLiveData<List<Tariff>>()
    val tariffsList: LiveData<List<Tariff>>
        get() = _tariffsList

    init {
        loadTariffs()
    }
    private fun loadTariffs(){
        _tariffsList.value = TariffGenerator.generateTariffs()
    }
}