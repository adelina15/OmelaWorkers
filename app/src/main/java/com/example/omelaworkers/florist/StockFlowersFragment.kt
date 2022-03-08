package com.example.omelaworkers.florist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.omelaworkers.R
import com.example.omelaworkers.databinding.FragmentSoldFlowersBinding
import com.example.omelaworkers.databinding.FragmentStockFlowersBinding
import com.example.omelaworkers.florist.adapter.BouquetAdapter
import com.example.omelaworkers.florist.model.Bouquet

class StockFlowersFragment : Fragment() {

    private var _binding: FragmentStockFlowersBinding? = null
    private val binding
        get() = _binding!!
    private val stockFlowersAdapter = BouquetAdapter()

    private val stockFlowersList by lazy {
        mutableListOf(
            Bouquet("ВРЕМЯ ЛЮБИТЬ", 8900, "шебби-шик", 890),
            Bouquet("ВРЕМЯ ЛЮБИТЬ", 8900, "шебби-шик", 890),
            Bouquet("ВРЕМЯ ЛЮБИТЬ", 8900, "шебби-шик", 890),
            Bouquet("ВРЕМЯ ЛЮБИТЬ", 8900, "шебби-шик", 890),
            Bouquet("ВРЕМЯ ЛЮБИТЬ", 8900, "шебби-шик", 890),
            Bouquet("ВРЕМЯ ЛЮБИТЬ", 8900, "шебби-шик", 890),
            Bouquet("ВРЕМЯ ЛЮБИТЬ", 8900, "шебби-шик", 890),
            Bouquet("ВРЕМЯ ЛЮБИТЬ", 8900, "шебби-шик", 890),
            Bouquet("ВРЕМЯ ЛЮБИТЬ", 8900, "шебби-шик", 890),
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stock_flowers, container, false)
        init()
        return binding.root
    }
    private fun init() {
        binding.apply {
            stockFlowersRecyclerView.adapter = stockFlowersAdapter
        }
        stockFlowersAdapter.setList(stockFlowersList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}