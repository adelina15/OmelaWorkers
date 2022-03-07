package com.example.omelaworkers.courier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.omelaworkers.R
import com.example.omelaworkers.courier.adapters.DetailsAdapter
import com.example.omelaworkers.courier.model.OrderFlower
import com.example.omelaworkers.databinding.FragmentOrderDetailsBinding

class OrderDetailsFragment : Fragment() {

    private var _binding: FragmentOrderDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val detailsAdapter = DetailsAdapter()

    private val flowersList by lazy {
        mutableListOf(
            OrderFlower(
                "ПРИКОСНОВЕНИЕ",
                R.drawable.cat_3,
                8000,
                15
            ),
            OrderFlower(
                "ИСКРЕННОСТЬ",
                R.drawable.cat_3,
                6800,
            ),
            OrderFlower(
                "ЧИСТОЕ СЕРДЦЕ",
                R.drawable.cat_3,
                4000,
            )
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_details, container, false)
        init()
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.toolbar) {
            setNavigationIcon(R.drawable.ic_back_arrow)
            setNavigationOnClickListener {
                val action = OrderDetailsFragmentDirections.actionOrderDetailsFragmentToHomeFragment()
                findNavController().navigate(action)
            }
        }
    }

    private fun init() {
        binding.apply {
            flowersRecyclerView.adapter = detailsAdapter
        }
        detailsAdapter.setList(flowersList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}