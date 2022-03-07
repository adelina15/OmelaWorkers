package com.example.omelaworkers.courier.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omelaworkers.R
import com.example.omelaworkers.courier.Delegates
import com.example.omelaworkers.courier.model.NewOrder
import com.example.omelaworkers.databinding.NewOrderBinding

class NewOrdersAdapter(private val orderClicker: Delegates.OrderClicked): RecyclerView.Adapter<NewOrdersAdapter.NewOrdersHolder>() {

    private var list = mutableListOf<NewOrder>()
    fun setList (list : MutableList<NewOrder>){
        this.list = list
    }

    class NewOrdersHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = NewOrderBinding.bind(item)
        fun bind(order: NewOrder) = with(binding) {
            newClientName.text = order.client_name
            newClientAddress.text = order.client_address
            newClientNumber.text = order.client_number
            newOrderTime.text = order.order_time
            newOrderBranch.text = order.branch_address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewOrdersHolder {
        val view = LayoutInflater.from((parent.context)).inflate(R.layout.new_order, parent, false)
        return NewOrdersHolder(view)
    }

    override fun onBindViewHolder(holder: NewOrdersHolder, position: Int) {
        holder.bind(list[position])
        holder.binding.layout.setOnClickListener {
            orderClicker.onItemClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}