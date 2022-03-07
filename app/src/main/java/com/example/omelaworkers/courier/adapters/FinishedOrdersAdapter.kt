package com.example.omelaworkers.courier.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omelaworkers.R
import com.example.omelaworkers.courier.Delegates
import com.example.omelaworkers.courier.model.NewOrder
import com.example.omelaworkers.databinding.NewOrderBinding

class FinishedOrdersAdapter (private val orderClicker: Delegates.OrderClicked): RecyclerView.Adapter<FinishedOrdersAdapter.FinishedOrdersHolder>() {

    private var list = mutableListOf<NewOrder>()
    fun setList (list : MutableList<NewOrder>){
        this.list = list
    }

    class FinishedOrdersHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = NewOrderBinding.bind(item)
        fun bind(order: NewOrder) = with(binding) {
            newClientName.text = order.client_name
            newClientAddress.text = order.client_address
            newClientNumber.text = order.client_number
            newOrderTime.text = order.order_time
            newOrderBranch.text = order.branch_address
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