package com.example.omelaworkers.courier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.omelaworkers.R
import com.example.omelaworkers.courier.adapters.CurrentOrdersAdapter
import com.example.omelaworkers.courier.adapters.NewOrdersAdapter
import com.example.omelaworkers.courier.model.CurrentOrder
import com.example.omelaworkers.courier.model.NewOrder
import com.example.omelaworkers.databinding.FragmentCurrentOrderBinding
import com.example.omelaworkers.databinding.FragmentHomeBinding

class CurrentOrderFragment : Fragment(), Delegates.CurrentOrderClicked {

    private var _binding: FragmentCurrentOrderBinding? = null
    private val binding
        get() = _binding!!
    private val currentOrdersAdapter = CurrentOrdersAdapter(this)
    private val currentOrdersList by lazy {
        mutableListOf(
            CurrentOrder(
                "Каныкей",
                "+996 000 123 456",
                "проспект Чингиза Айтматова 305, дом 45, кв. 45",
                "г. Бишкек, проспект чуй 147/1.",
                "11:37",
                "принял"
            ),
            CurrentOrder(
                "Алена",
                "+996 990 123 456",
                "проспект Чингиза Айтматова 305, дом 45, кв. 45",
                "г. Бишкек, проспект чуй 147/1.",
                "11:37",
                "в пути"
            ),
            CurrentOrder(
                "Миша",
                "+996 000 123 456",
                "проспект Чингиза Айтматова 305, дом 45, кв. 45",
                "г. Бишкек, проспект чуй 147/1.",
                "11:37",
                "доставил"
            )
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_order, container, false)
        init()
        return binding.root
    }
    private fun init() {
        binding.apply {
            currentOrdersRecyclerView.adapter = currentOrdersAdapter
        }
        currentOrdersAdapter.setList(currentOrdersList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(order: CurrentOrder) {
        val action = HistoryFragmentDirections.actionHistoryFragmentToOrderDetailsFragment(order.order_status)
        findNavController().navigate(action)
    }
}