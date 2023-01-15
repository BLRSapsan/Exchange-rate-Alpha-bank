package com.exchangeratealphabank.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.exchangeratealphabank.R
import com.exchangeratealphabank.first_screen.FirstFragment
import com.exchangeratealphabank.second_screen.SecondFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.pager)
        viewPager.adapter = ViewPagerFragments(this)

        TabLayoutMediator(tabMode, pager) { tab, position -> //кнопки tabLayout
            when (position) {
                0 -> tab.setText(R.string.rate_alpha)
                1 -> tab.setText(R.string.rate_national_bank)
            }
        }.attach()
    }
}