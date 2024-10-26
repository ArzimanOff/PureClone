package com.arziman_off.pureclone.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arziman_off.pureclone.R

class LikesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    private fun parseParams() {
        // Реализовать в случае если будут передаваться аргументы на фрагмент
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_likes, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            LikesFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}