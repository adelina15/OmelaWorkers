package com.example.omelaworkers.florist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.omelaworkers.R
import com.example.omelaworkers.courier.SalaryFragmentDirections
import com.example.omelaworkers.courier.adapters.SalaryAdapter
import com.example.omelaworkers.courier.model.Salary
import com.example.omelaworkers.databinding.FragmentFloristSalaryBinding

class FloristSalaryFragment : Fragment() {

    private var _binding: FragmentFloristSalaryBinding? = null
    private val binding
        get() = _binding!!
    private val salaryAdapter = SalaryAdapter()
    private val salaryList by lazy {
        mutableListOf(
            Salary(
                "24.02.2022г.", 4, 990),
            Salary("23.02.2022г.", 1, 290),
            Salary("22.02.2022г.", 6, 1090),
            Salary("21.02.2022г.", 3, 780),
            Salary(
                "20.02.2022г.",
                2,
                1900
            ),
            Salary(
                "19.02.2022г.",
                4,
                2000
            ),
            Salary(
                "18.02.2022г.",
                4,
                455
            ),
            Salary(
                "17.02.2022г.",
                4,
                344
            ),
            Salary(
                "16.02.2022г.",
                5,
                899
            ),
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_florist_salary, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.toolbar) {
            setNavigationIcon(com.example.omelaworkers.R.drawable.ic_back_arrow)
            setNavigationOnClickListener {
                val action = FloristSalaryFragmentDirections.actionFloristSalaryFragmentToFloristAccountFragment()
                findNavController().navigate(action)
            }
        }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.filter_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.salarySpinner2.adapter = adapter
        }
    }

    private fun init() {
        binding.salaryRecyclerView.adapter = salaryAdapter
        salaryAdapter.setList(salaryList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}