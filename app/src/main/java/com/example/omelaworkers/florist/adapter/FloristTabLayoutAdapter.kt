package com.example.omelaworkers.florist.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.omelaworkers.florist.SoldFlowersFragment
import com.example.omelaworkers.florist.StockFlowersFragment

class FloristTabLayoutAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                StockFlowersFragment()
            }
            1 -> {
                SoldFlowersFragment()
            }
            else -> {
                Fragment()
            }
        }

    }
}