package com.exchangeratealphabank.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.exchangeratealphabank.first_screen.FirstFragment
import com.exchangeratealphabank.second_screen.SecondFragment

class ViewPagerFragments(fa: FragmentActivity) : FragmentStateAdapter(fa){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            else -> SecondFragment()
        }
    }
}