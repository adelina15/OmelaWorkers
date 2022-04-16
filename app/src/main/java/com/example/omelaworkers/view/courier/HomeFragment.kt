package com.example.omelaworkers.view.courier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.omelaworkers.R
import com.example.omelaworkers.view.courier.adapters.NewOrdersAdapter
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.databinding.FragmentHomeBinding
import com.example.omelaworkers.viewmodel.NewOrdersViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), Delegates.OrderClicked {

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!
    private val newOrdersAdapter = NewOrdersAdapter(this)
    private val newOrdersViewModel by viewModel<NewOrdersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(newOrdersViewModel)
        init()
        newOrdersViewModel.newOrdersLiveData.observe(viewLifecycleOwner){
            newOrdersAdapter.setList(it.toList())
        }
    }

    private fun init() {
        binding.apply {
            recyclerView.adapter = newOrdersAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(order: OrdersItem) {
        val action = HomeFragmentDirections.actionHomeFragmentToOrderDetailsFragment("новый заказ", order)
        findNavController().navigate(action)
    }
}