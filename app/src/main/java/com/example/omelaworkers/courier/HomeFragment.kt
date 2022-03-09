package com.example.omelaworkers.courier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.omelaworkers.R
import com.example.omelaworkers.courier.adapters.NewOrdersAdapter
import com.example.omelaworkers.courier.model.NewOrder
import com.example.omelaworkers.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), Delegates.OrderClicked {

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!
    private val newOrdersAdapter = NewOrdersAdapter(this)
    private val newOrdersList by lazy {
        mutableListOf(
            NewOrder(
                "Каныкей",
                "+996 000 123 456",
                "проспект Чингиза Айтматова 305, дом 45, кв. 45",
                "г. Бишкек, проспект чуй 147/1.",
                "11:37"
            ),
            NewOrder(
                "Алена",
                "+996 990 123 456",
                "проспект Чингиза Айтматова 305, дом 45, кв. 45",
                "г. Бишкек, проспект чуй 147/1.",
                "11:37"
            ),
            NewOrder(
                "Миша",
                "+996 000 123 456",
                "проспект Чингиза Айтматова 305, дом 45, кв. 45",
                "г. Бишкек, проспект чуй 147/1.",
                "11:37"
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.apply {
            recyclerView.adapter = newOrdersAdapter
        }
        newOrdersAdapter.setList(newOrdersList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(order: NewOrder) {
        val action = HomeFragmentDirections.actionHomeFragmentToOrderDetailsFragment("новый заказ")
        findNavController().navigate(action)
    }
}