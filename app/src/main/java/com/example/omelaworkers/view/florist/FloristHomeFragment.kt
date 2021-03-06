package com.example.omelaworkers.view.florist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.omelaworkers.R
import com.example.omelaworkers.databinding.FragmentFloristHomeBinding
import com.example.omelaworkers.view.florist.adapter.FlowerAdapter
import com.example.omelaworkers.data.model.Flower
import com.example.omelaworkers.viewmodel.FlowersViewModel
import com.example.omelaworkers.viewmodel.NewOrdersViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FloristHomeFragment : Fragment() {

    private var _binding: FragmentFloristHomeBinding? = null
    private val binding
        get() = _binding!!
    private val flowersAdapter = FlowerAdapter()
    private val flowersViewModel by viewModel<FlowersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_florist_home, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addFlower.setOnClickListener {
            val action = FloristHomeFragmentDirections.actionFloristHomeFragmentToAddFlowerFragment()
            findNavController().navigate(action)
        }
        lifecycle.addObserver(flowersViewModel)
        init()
        flowersViewModel.flowersLiveData.observe(viewLifecycleOwner){
            flowersAdapter.setList(it.toList())
        }
    }

    private fun init() {
        binding.apply {
            flowerRecyclerView.adapter = flowersAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}