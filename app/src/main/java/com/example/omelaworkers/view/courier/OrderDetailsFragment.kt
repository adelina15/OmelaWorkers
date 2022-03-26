package com.example.omelaworkers.view.courier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.omelaworkers.R
import com.example.omelaworkers.view.courier.adapters.DetailsAdapter
import com.example.omelaworkers.data.model.OrderFlower
import com.example.omelaworkers.databinding.FragmentOrderDetailsBinding

class OrderDetailsFragment : Fragment() {

    private val args by navArgs<OrderDetailsFragmentArgs>()

    private var _binding: FragmentOrderDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val detailsAdapter = DetailsAdapter()
    private val flowersList by lazy {
        mutableListOf(
            OrderFlower("ПРИКОСНОВЕНИЕ", R.drawable.cat_3, 8000, 15),
            OrderFlower("ИСКРЕННОСТЬ", R.drawable.cat_3, 6800),
            OrderFlower("ЧИСТОЕ СЕРДЦЕ", R.drawable.cat_3, 4000)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_order_details, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.toolbar) {
            setNavigationIcon(R.drawable.ic_back_arrow)
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
        binding.status.text = args.status
        if (binding.status.text == "новый заказ") {
            binding.acceptButton.visibility = View.GONE
            binding.statusButton.visibility = View.VISIBLE
        }
        if (binding.status.text == "завершил") {
            binding.acceptButton.visibility = View.GONE
        }
        if (binding.status.text == "принял") {
            binding.acceptButton.apply {
                background = ContextCompat.getDrawable(
                    context,
                    R.drawable.button_yellow
                )
                isEnabled = true
            }
            binding.acceptButton.text = "забрал"
        }
        if (binding.status.text == "в пути") {
            binding.acceptButton.apply {
                background = ContextCompat.getDrawable(
                    context,
                    R.drawable.button_peach
                )
                isEnabled = true
            }
            binding.acceptButton.text = "доставил"
        }
        if (binding.status.text == "доставил") {
            binding.acceptButton.apply {
                background = ContextCompat.getDrawable(
                    context,
                    R.drawable.button_green
                )
                isEnabled = true
            }
            binding.acceptButton.text = "завершил"
        }
        binding.acceptButton.setOnClickListener {
            when (binding.status.text) {
                "принял" -> {
                    binding.acceptButton.apply {
                        background = ContextCompat.getDrawable(
                            context,
                            R.drawable.button_peach
                        )
                        isEnabled = true
                    }
                    binding.acceptButton.text = "доставил"
                    binding.status.text = "в пути"
                }
                "в пути" -> {
                    binding.acceptButton.apply {
                        background = ContextCompat.getDrawable(
                            context,
                            R.drawable.button_green
                        )
                        isEnabled = true
                    }
                    binding.acceptButton.text = "завершил"
                    binding.status.text = "доставил"
                }
                "доставил" -> {
                    binding.acceptButton.visibility = View.GONE
                    binding.status.text = "завершил"
                }
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