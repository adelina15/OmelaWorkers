package com.example.omelaworkers.view.courier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.omelaworkers.R
import com.example.omelaworkers.view.courier.adapters.CurrentOrdersAdapter
import com.example.omelaworkers.data.model.CurrentOrder
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.databinding.FragmentCurrentOrderBinding
import com.example.omelaworkers.viewmodel.ActiveOrdersViewModel
import com.example.omelaworkers.viewmodel.NewOrdersViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CurrentOrderFragment : Fragment(), Delegates.OrderClicked {

    private var _binding: FragmentCurrentOrderBinding? = null
    private val binding
        get() = _binding!!
    private val currentOrdersAdapter = CurrentOrdersAdapter(this)
    private val activeOrdersViewModel by viewModel<ActiveOrdersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_order, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(activeOrdersViewModel)
        init()
        activeOrdersViewModel.activeOrdersLiveData.observe(viewLifecycleOwner){
            currentOrdersAdapter.setList(it.toList())
        }
    }
    private fun init() {
        binding.apply {
            currentOrdersRecyclerView.adapter = currentOrdersAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(order: OrdersItem) {
        val status = when(order.status){
            "COURIER_GO" -> "в пути"
            "COURIER_TAKE" -> "забрал"
            else -> "завершил"
        }
        val action = HistoryFragmentDirections.actionHistoryFragment2ToOrderDetailsFragment2(status, order)
        findNavController().navigate(action)
    }
}