package com.example.omelaworkers.view.courier.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omelaworkers.R
import com.example.omelaworkers.view.courier.Delegates
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.databinding.NewOrderBinding

class FinishedOrdersAdapter (private val orderClicker: Delegates.OrderClicked): RecyclerView.Adapter<FinishedOrdersAdapter.FinishedOrdersHolder>() {

    private var list = mutableListOf<OrdersItem>()
    fun setList (list : MutableList<OrdersItem>){
        this.list = list
    }

    class FinishedOrdersHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = NewOrderBinding.bind(item)
        fun bind(order: OrdersItem) = with(binding) {
            newClientName.text = order.customerName
            newClientAddress.text = order.address
            newClientNumber.text = order.customer.phoneNumber
//            newOrderTime.text = order.
            newOrderBranch.text = "Киевская, 12"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinishedOrdersHolder {
        val view = LayoutInflater.from((parent.context)).inflate(R.layout.new_order, parent, false)
        return FinishedOrdersHolder(view)
    }

    override fun onBindViewHolder(holder:FinishedOrdersHolder, position: Int) {
        holder.bind(list[position])
        holder.binding.layout.setOnClickListener {
            orderClicker.onItemClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}