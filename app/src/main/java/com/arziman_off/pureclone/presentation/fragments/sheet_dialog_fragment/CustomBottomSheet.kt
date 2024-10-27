package com.arziman_off.pureclone.presentation.fragments.sheet_dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.data.TariffGenerator
import com.arziman_off.pureclone.presentation.recycler_tariffs.TariffsAdapter
import com.arziman_off.pureclone.presentation.view_models.CustomBottomSheetViewModel
import com.arziman_off.pureclone.presentation.view_models.CustomBottomSheetViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomSheet : BottomSheetDialogFragment() {

    private lateinit var tariffsRecyclerView: RecyclerView
    private lateinit var tariffsAdapter: TariffsAdapter

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            CustomBottomSheetViewModelFactory()
        )[CustomBottomSheetViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_custom_bottom_sheet, container, false)
        return view
    }

    private fun setupRecyclerView(view: View) {
        tariffsRecyclerView = view.findViewById(R.id.rv_tariffs)
        tariffsAdapter = TariffsAdapter()
        tariffsRecyclerView.setLayoutManager(GridLayoutManager(view.context, 3))
        tariffsAdapter.submitList(TariffGenerator.generateTariffs())
        tariffsRecyclerView.adapter = tariffsAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(view)
        val closeButton = view.findViewById<View>(R.id.closeButton)
        closeButton.setOnClickListener {
            dismiss()
        }
    }
}
