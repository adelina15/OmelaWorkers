package com.example.omelaworkers.view.courier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.omelaworkers.R
import com.example.omelaworkers.data.model.Bouquet
import com.example.omelaworkers.view.courier.adapters.DetailsAdapter
import com.example.omelaworkers.databinding.FragmentOrderDetailsBinding
import com.example.omelaworkers.viewmodel.NewOrdersViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class OrderDetailsFragment : Fragment() {

    private val args by navArgs<OrderDetailsFragmentArgs>()

    private var _binding: FragmentOrderDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val detailsAdapter = DetailsAdapter()
    lateinit var flowersList: List<Bouquet>
    private val newOrdersViewModel by viewModel<NewOrdersViewModel>()

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
        with(binding){
            clientName.text = args.order.customerName
            clientNumber.text = args.order.customer.phoneNumber
            clientAddress.text = args.order.address
            orderComment.text = args.order.suggestion
            orderTotal.text = "${args.order.totalSum} c"
//            courierPay.text =
            status.text = args.status
            if (status.text == "новый заказ") {
                acceptButton.visibility = View.GONE
                statusButton.visibility = View.VISIBLE
                statusButton.setOnClickListener {
                    newOrdersViewModel.changeStatus(args.order.id)
                }
            }
            if (status.text == "завершил") {
                acceptButton.visibility = View.GONE
            }
            if (status.text == "принял") {
                acceptButton.apply { background = ContextCompat.getDrawable(context, R.drawable.button_yellow)
                    isEnabled = true
                }
                acceptButton.text = "забрал"
            }
            if (status.text == "в пути") {
                acceptButton.apply {
                    background = ContextCompat.getDrawable(context, R.drawable.button_peach)
                    isEnabled = true
                }
                acceptButton.text = "доставил"
            }
            if (status.text == "доставил") {
                acceptButton.apply { background = ContextCompat.getDrawable(context, R.drawable.button_green)
                    isEnabled = true
                }
                acceptButton.text = "завершил"
            }
            acceptButton.setOnClickListener {
                when (status.text) {
                    "принял" -> {
                        acceptButton.apply { background = ContextCompat.getDrawable(context, R.drawable.button_peach)
                            isEnabled = true
                        }
                        acceptButton.text = "доставил"
                        status.text = "в пути"
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
    }

    private fun init() {
        binding.apply {
            flowersRecyclerView.adapter = detailsAdapter
        }
        flowersList = args.order.bouquets
        detailsAdapter.setList(flowersList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}