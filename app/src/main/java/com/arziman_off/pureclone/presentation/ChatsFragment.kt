package com.arziman_off.pureclone.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.presentation.recycler_chats.ChatsAdapter
import com.arziman_off.pureclone.presentation.view_models.ChatsViewModel
import com.arziman_off.pureclone.presentation.view_models.ChatsViewModelFactory


class ChatsFragment : Fragment() {

    private lateinit var chatsRecyclerView: RecyclerView
    private lateinit var chatsAdapter: ChatsAdapter

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ChatsViewModelFactory()
        )[ChatsViewModel::class.java]
    }

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
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        setupRecyclerView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupViewModelObservers()
    }

    private fun setupViewModelObservers() {
        viewModel.chatsList.observe(viewLifecycleOwner) {
            chatsAdapter.submitList(it)
        }
        viewModel.isLoading.observe(viewLifecycleOwner){
            //TODO
        }
    }

    private fun initViews(view: View) {

    }

    private fun setupRecyclerView(view: View) {
        chatsRecyclerView = view.findViewById(R.id.rv_chats)
        chatsAdapter = ChatsAdapter()
        chatsRecyclerView.adapter = chatsAdapter

        viewModel.loadChatsInfo()

        // Настройка адаптера
        chatsAdapter.submitList(viewModel.chatsList.value)
        chatsRecyclerView.adapter = chatsAdapter
    }



    companion object {
        @JvmStatic
        fun newInstance() =
            ChatsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}