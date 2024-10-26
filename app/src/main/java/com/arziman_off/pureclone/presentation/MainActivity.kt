package com.arziman_off.pureclone.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.arziman_off.pureclone.R
import com.arziman_off.pureclone.presentation.fragments.ChatsListFragment
import com.arziman_off.pureclone.presentation.fragments.HomeFragment
import com.arziman_off.pureclone.presentation.fragments.LikesFragment
import com.arziman_off.pureclone.presentation.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setClickListeners()
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.navigation_chats
            val fragment = ChatsListFragment.newInstance()
            launchFragment(fragment)
        }
    }

    private fun setClickListeners() {
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_main -> {
                    val fragment = HomeFragment.newInstance()
                    launchFragment(fragment)
                }
                R.id.navigation_chats -> {
                    val fragment = ChatsListFragment.newInstance()
                    launchFragment(fragment)
                }
                R.id.navigation_likes -> {
                    val fragment = LikesFragment.newInstance()
                    launchFragment(fragment)
                }
                R.id.navigation_settings -> {
                    val fragment = SettingsFragment.newInstance()
                    launchFragment(fragment)
                }
            }
            true
        }
    }

    private fun initViews() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
    }

    private fun launchFragment(fragment: Fragment){
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}