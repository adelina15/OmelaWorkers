package com.example.omelaworkers.view.courier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.omelaworkers.R
import com.example.omelaworkers.view.courier.adapters.TabLayoutAdapter
import com.example.omelaworkers.databinding.FragmentHistoryBinding
import com.google.android.material.tabs.TabLayoutMediator

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TabLayoutAdapter(this)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        //create text and fragments for each tab
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "текущие"
                }
                1 -> {
                    tab.text = "завершенные"
                }
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}