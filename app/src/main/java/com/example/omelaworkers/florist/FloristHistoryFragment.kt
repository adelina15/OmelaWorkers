package com.example.omelaworkers.florist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.omelaworkers.R
import com.example.omelaworkers.courier.adapters.TabLayoutAdapter
import com.example.omelaworkers.databinding.FragmentFloristHistoryBinding
import com.example.omelaworkers.florist.adapter.FloristTabLayoutAdapter
import com.google.android.material.tabs.TabLayoutMediator

class FloristHistoryFragment : Fragment() {

    private var _binding: FragmentFloristHistoryBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_florist_history, container, false)

        val adapter = FloristTabLayoutAdapter(this)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        //create text and fragments for each tab
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "в наличии"
                }
                1 -> {
                    tab.text = "проданные"
                }
            }
        }.attach()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}