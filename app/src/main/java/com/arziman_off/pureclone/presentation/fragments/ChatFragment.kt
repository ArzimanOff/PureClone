package com.arziman_off.pureclone.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.domain.Message
import com.arziman_off.pureclone.domain.UserChat
import com.arziman_off.pureclone.presentation.view_models.ChatViewModel
import com.arziman_off.pureclone.presentation.view_models.ChatViewModelFactory
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.hdodenhof.circleimageview.CircleImageView

class ChatFragment : Fragment() {

    private var userChat: UserChat? = null

    private lateinit var profileImage: CircleImageView
    private lateinit var btnBack: ImageView
    private lateinit var btnMenu: ImageView
    private lateinit var btnSendMessage: ImageView
    private lateinit var btnAudioMsg: ImageView
    private lateinit var etNewMessageInput: EditText

    private lateinit var notify: LinearLayout
    private lateinit var notifyText: TextView
    private lateinit var btnHideNotify: ImageView

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ChatViewModelFactory()
        )[ChatViewModel::class.java]
    }

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

        userChat = arguments?.getParcelable<UserChat>(ARG_USER_CHAT)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        getChatInfo()
        setEventListeners()
        setViewModelObservers()
    }

    private fun getChatInfo() {
        Glide.with(this)
            .load(userChat?.avatarUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(profileImage)
    }

    private fun setViewModelObservers() {
        viewModel.toastMsg.observe(viewLifecycleOwner) {
            Toast.makeText(
                context,
                "Сообщение отправлено!",
                Toast.LENGTH_SHORT
            ).show()
        }

        viewModel.cntOfTemptations.observe(viewLifecycleOwner){
            notifyText.text = it
        }
    }

    private fun setEventListeners() {
        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack() // Возвращаемся к предыдущему фрагменту
        }

        btnHideNotify.setOnClickListener {
            notify.visibility = View.GONE
        }
        btnSendMessage.setOnClickListener {
            val msgText = etNewMessageInput.text.trim().toString()
            val message = Message(
                userChat!!.id,
                0, // 0 временно
                msgText
            )
            viewModel.sendTextMessage(message)
        }


        // Добавляем TextWatcher для отслеживания изменений текста
        etNewMessageInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // До изменения текста
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // Когда текст изменяется
                val inputText =
                    charSequence.toString().trim { it <= ' ' } // Убираем пробелы в начале и в конце

                if (inputText.isNotEmpty()) {
                    // Если текст введен, меняем иконку на активную
                    btnAudioMsg.visibility = View.GONE
                    btnSendMessage.visibility = View.VISIBLE
                } else {
                    // Если поле пустое (или только пробелы), возвращаем неактивную иконку
                    btnAudioMsg.visibility = View.VISIBLE
                    btnSendMessage.visibility = View.GONE
                }
            }

            override fun afterTextChanged(editable: Editable) {
                // После изменения текста
            }
        })
    }

    private fun initViews(view: View) {
        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav?.visibility = View.GONE

        profileImage = view.findViewById(R.id.profile_image)
        btnBack = view.findViewById(R.id.btnBack)
        btnMenu = view.findViewById(R.id.btnMenu)

        btnSendMessage = view.findViewById(R.id.btnSendMessage)
        btnAudioMsg = view.findViewById(R.id.btnAudioMsg)
        etNewMessageInput = view.findViewById(R.id.etNewMessageInput)

        notify = view.findViewById(R.id.notify)
        notify.visibility = View.VISIBLE

        notifyText = view.findViewById(R.id.notifyText)
        btnHideNotify = view.findViewById(R.id.btnHideNotify)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav?.visibility = View.VISIBLE
    }

}
