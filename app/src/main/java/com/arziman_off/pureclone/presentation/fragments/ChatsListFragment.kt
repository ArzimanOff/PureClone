package com.arziman_off.pureclone.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.domain.UserChat
import com.arziman_off.pureclone.presentation.CustomSwitch
import com.arziman_off.pureclone.presentation.fragments.sheet_dialog_fragment.CustomBottomSheet
import com.arziman_off.pureclone.presentation.recycler_chats.ChatClickListener
import com.arziman_off.pureclone.presentation.recycler_chats.ChatsAdapter
import com.arziman_off.pureclone.presentation.view_models.ChatsListViewModel
import com.arziman_off.pureclone.presentation.view_models.ChatsListViewModelFactory


class ChatsListFragment : Fragment(), ChatClickListener {

    private lateinit var chatsRecyclerView: RecyclerView
    private lateinit var chatsAdapter: ChatsAdapter

    private lateinit var likesCntText: TextView

    private lateinit var switchModeStatus: TextView
    private lateinit var switchMode: CustomSwitch

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ChatsListViewModelFactory()
        )[ChatsListViewModel::class.java]
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
        val view = inflater.inflate(R.layout.fragment_chats_list, container, false)

        setupRecyclerView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupViewModelObservers()
        setOnEventListeners()
    }

    private fun setOnEventListeners() {
        switchMode.setOnCheckedChangeListener {isChecked ->
            if (isChecked){
                switchModeStatus.text = getString(R.string.switchModeStatusOn)
            } else {
                switchModeStatus.text = getString(R.string.switchModeStatusOff)
            }
            //TODO добавить логику появления окна покупки если режим изоляции еще не куплен
            val bottomSheet = CustomBottomSheet()
            bottomSheet.show(parentFragmentManager, "CustomBottomSheet")
        }
    }

    private fun setupViewModelObservers() {
        viewModel.chatsList.observe(viewLifecycleOwner) {
            chatsAdapter.submitList(it)
        }
        viewModel.likesCntText.observe(viewLifecycleOwner) {
            likesCntText.text = it
        }
        viewModel.chatListIsLoading.observe(viewLifecycleOwner) {
            //TODO
        }
        viewModel.likesCntIsLoading.observe(viewLifecycleOwner) {
            //TODO
        }
    }

    private fun initViews(view: View) {
        likesCntText = view.findViewById(R.id.likesCntText)
        switchModeStatus = view.findViewById(R.id.switchModeStatus)
        switchMode = view.findViewById(R.id.switchMode)
    }

    private fun setupRecyclerView(view: View) {
        chatsRecyclerView = view.findViewById(R.id.rv_chats)
        chatsAdapter = ChatsAdapter(this)
        chatsRecyclerView.adapter = chatsAdapter

        viewModel.loadChatsInfo()

        // Настройка адаптера
        chatsAdapter.submitList(viewModel.chatsList.value)
        chatsRecyclerView.adapter = chatsAdapter
    }

    override fun onChatClick(userChat: UserChat) {
        val chatFragment = ChatFragment.newInstance(userChat)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, chatFragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ChatsListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}