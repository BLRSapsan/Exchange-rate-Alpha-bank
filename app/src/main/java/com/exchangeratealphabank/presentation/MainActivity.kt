package com.exchangeratealphabank.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.exchangeratealphabank.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

const val TAGExchangeRate = "logirovanie"
class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = ViewPagerFragments(this)

        TabLayoutMediator(tabMode, pager) { tab, position ->
            when (position) {
                0 -> tab.setText(R.string.rate_alpha)
                1 -> tab.setText(R.string.rate_national_bank)
            }
        }.attach()
    }
}