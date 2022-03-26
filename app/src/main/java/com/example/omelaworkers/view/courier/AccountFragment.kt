package com.example.omelaworkers.view.courier

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.omelaworkers.view.LoginActivity
import com.example.omelaworkers.R
import com.example.omelaworkers.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {
    private var _binding: FragmentAccountBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            salaryButton.setOnClickListener {
                val action = AccountFragmentDirections.actionAccountFragmentToSalaryFragment()
                findNavController().navigate(action)
            }
            logOutButton.setOnClickListener {
                alertDialog()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun alertDialog() {
        val builder = AlertDialog.Builder(requireContext(), R.style.AlertDialogCustom)
        builder.setTitle("вы действительно хотите выйти?")
//        builder.setMessage("")
        builder.setPositiveButton("да") { _, _ ->
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
        builder.setNegativeButton("нет") { _, _ ->
            Toast.makeText(requireContext(),
                "действие отменено", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }
}