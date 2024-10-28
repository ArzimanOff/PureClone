package com.arziman_off.pureclone.presentation

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.arziman_off.pureclone.R

class CustomSwitch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var isChecked = false // добавить получение состояние из ViewModel главной активити

    private val switchThumbOn: ImageView
    private val switchThumbOff: ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_switch, this, true)
        switchThumbOn = findViewById(R.id.switchThumbOn)
        switchThumbOff = findViewById(R.id.switchThumbOff)

        updateSwitchUI()

        setOnClickListener {
            toggle()
        }
    }

    private fun toggle() {
        isChecked = !isChecked
        Log.d("CustomSwitch", "Switch toggled: $isChecked")
        updateSwitchUI()
    }

    private fun updateSwitchUI() {
        if (isChecked) {
            Log.d("CustomSwitch", "Switch is ON")
            switchThumbOn.visibility = View.VISIBLE
            switchThumbOff.visibility = View.GONE
        } else {
            Log.d("CustomSwitch", "Switch is OFF")
            switchThumbOn.visibility = View.GONE
            switchThumbOff.visibility = View.VISIBLE
        }
    }

    fun isChecked(): Boolean = isChecked

    fun setChecked(checked: Boolean) {
        if (isChecked != checked) {
            isChecked = checked
            updateSwitchUI()
        }
    }

    fun setOnCheckedChangeListener(listener: (Boolean) -> Unit) {
        setOnClickListener {
            toggle()
            listener(isChecked)
        }
    }
}
