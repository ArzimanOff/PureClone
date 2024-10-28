package com.arziman_off.pureclone.presentation.fragments.sheet_dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.domain.Tariff
import com.arziman_off.pureclone.presentation.fragments.PaymentFragment
import com.arziman_off.pureclone.presentation.recycler_tariffs.TariffsAdapter
import com.arziman_off.pureclone.presentation.view_models.CustomBottomSheetViewModel
import com.arziman_off.pureclone.presentation.view_models.CustomBottomSheetViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton

class CustomBottomSheet : BottomSheetDialogFragment() {
    private var selectedTariff: Tariff? = null

    private lateinit var tariffsRecyclerView: RecyclerView
    private lateinit var tariffsAdapter: TariffsAdapter
    private lateinit var btnBuy: MaterialButton

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
        tariffsAdapter = TariffsAdapter(){
            selectedTariff = it
        }
        tariffsRecyclerView.setLayoutManager(GridLayoutManager(view.context, 3))

        tariffsRecyclerView.adapter = tariffsAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(view)
        btnBuy = view.findViewById(R.id.btn_buy)
        btnBuy.setOnClickListener {
            dismiss()
            val fragment = if (selectedTariff != null){
                PaymentFragment.newInstance(selectedTariff!!)
            }  else {
                PaymentFragment.newInstance(tariffsAdapter.getTariff())
            }
            launchFragment(fragment)
        }

        viewModel.tariffsList.observe(viewLifecycleOwner){
            tariffsAdapter.submitList(it)
        }
        val closeButton = view.findViewById<View>(R.id.closeButton)
        closeButton.setOnClickListener {
            dismiss()
        }
    }

    private fun launchFragment(fragment: Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}
