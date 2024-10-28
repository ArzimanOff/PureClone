package com.arziman_off.pureclone.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.domain.Tariff

class PaymentFragment : Fragment() {

    private var tariff: Tariff? = null

    private lateinit var cost: TextView
    private lateinit var cnt: TextView
    private lateinit var tariff_highlight: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tariff = arguments?.getParcelable<Tariff>(ARG_TARIFF)
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cost = view.findViewById(R.id.cost)
        cnt = view.findViewById(R.id.cnt)
        tariff_highlight = view.findViewById(R.id.tariff_highlight)
        val closeButton = view.findViewById<View>(R.id.closeButton)
        closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        cnt.text = tariff?.cnt.toString()
        cost.text = String.format("${tariff?.cost} ₽")
        if (tariff?.highlighting == true){
            tariff_highlight.visibility = View.VISIBLE
            tariff_highlight.text = tariff?.highlightingText
        } else {
            tariff_highlight.visibility = View.GONE
        }
    }

    companion object {
        private const val ARG_TARIFF = "selectedTariff"

        @JvmStatic
        fun newInstance(tariff: Tariff) =
            PaymentFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_TARIFF, tariff)
                }
            }
    }
}