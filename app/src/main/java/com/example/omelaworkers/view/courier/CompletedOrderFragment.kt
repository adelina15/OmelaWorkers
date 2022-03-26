package com.example.omelaworkers.view.courier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.omelaworkers.R
import com.example.omelaworkers.view.courier.adapters.CurrentOrdersAdapter
import com.example.omelaworkers.data.model.CurrentOrder
import com.example.omelaworkers.databinding.FragmentCompletedOrderBinding

class CompletedOrderFragment : Fragment(), Delegates.CurrentOrderClicked {
    private var _binding: FragmentCompletedOrderBinding? = null
    private val binding
        get() = _binding!!
    private val completedOrdersAdapter = CurrentOrdersAdapter(this)

    private val completedOrdersList by lazy {
        mutableListOf(
            CurrentOrder(
                "Каныкей",
                "+996 000 123 456",
                "проспект Чингиза Айтматова 305, дом 45, кв. 45",
                "г. Бишкек, проспект чуй 147/1.",
                "11:37",
                "23.02.22"
            ),
            CurrentOrder(
                "Алена",
                "+996 990 123 456",
                "проспект Чингиза Айтматова 305, дом 45, кв. 45",
                "г. Бишкек, проспект чуй 147/1.",
                "11:37",
                "22.02.22"
            ),
            CurrentOrder(
                "Миша",
                "+996 000 123 456",
                "проспект Чингиза Айтматова 305, дом 45, кв. 45",
                "г. Бишкек, проспект чуй 147/1.",
                "11:37",
                "21.02.22"

            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_completed_order, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.filter_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.orderSpinner.adapter = adapter
        }
    }
    private fun init() {
        binding.apply {
            completedOrdersRecyclerView.adapter = completedOrdersAdapter
        }
        completedOrdersAdapter.setList(completedOrdersList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(order: CurrentOrder) {
        val action = HistoryFragmentDirections.actionHistoryFragment2ToOrderDetailsFragment2("завершил")
        findNavController().navigate(action)
    }

}