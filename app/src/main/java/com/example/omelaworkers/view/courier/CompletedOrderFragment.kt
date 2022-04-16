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
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.databinding.FragmentCompletedOrderBinding
import com.example.omelaworkers.viewmodel.ActiveOrdersViewModel
import com.example.omelaworkers.viewmodel.FinishedOrdersViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CompletedOrderFragment : Fragment(), Delegates.OrderClicked {
    private var _binding: FragmentCompletedOrderBinding? = null
    private val binding
        get() = _binding!!
    private val completedOrdersAdapter = CurrentOrdersAdapter(this)
    private val finishedOrdersViewModel by viewModel<FinishedOrdersViewModel>()


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

        lifecycle.addObserver(finishedOrdersViewModel)
        init()
        finishedOrdersViewModel.finishedOrdersLiveData.observe(viewLifecycleOwner){
            completedOrdersAdapter.setList(it.toList())
        }
    }
    private fun init() {
        binding.apply {
            completedOrdersRecyclerView.adapter = completedOrdersAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(order: OrdersItem) {
        val action = HistoryFragmentDirections.actionHistoryFragment2ToOrderDetailsFragment2("завершил", order)
        findNavController().navigate(action)
    }

}