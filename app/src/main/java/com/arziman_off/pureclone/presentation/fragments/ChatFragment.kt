package com.arziman_off.pureclone.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.domain.UserChat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ChatFragment : Fragment() {

    companion object {
        private const val ARG_USER_CHAT = "userChat"

        fun newInstance(userChat: UserChat): ChatFragment {
            val fragment = ChatFragment()
            val args = Bundle()
            args.putParcelable(ARG_USER_CHAT, userChat)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        val userChat = arguments?.getParcelable<UserChat>(ARG_USER_CHAT)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav?.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav?.visibility = View.VISIBLE
    }

}
