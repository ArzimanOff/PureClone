package com.arziman_off.pureclone.presentation.fragments.sheet_dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arziman_off.pureclone.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_bottom_sheet, container, false)
    }

    // Закрытие по клику на крестик
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton = view.findViewById<View>(R.id.closeButton)
        closeButton.setOnClickListener {
            dismiss()  // Закрываем модальное окно
        }
    }
}
