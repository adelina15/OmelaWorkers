package com.example.omelaworkers.view.courier.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omelaworkers.R
import com.example.omelaworkers.view.courier.Delegates
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.databinding.NewOrderBinding

class NewOrdersAdapter(private val orderClicker: Delegates.OrderClicked): RecyclerView.Adapter<NewOrdersAdapter.NewOrdersHolder>() {

    private var list = listOf<OrdersItem>()

    fun setList(newList: List<OrdersItem>){
        list = newList
        notifyDataSetChanged()
    }

    class NewOrdersHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = NewOrderBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(order: OrdersItem) = with(binding) {
            newClientName.text = order.customerName
            newClientAddress.text = order.address
            newClientNumber.text = order.customer.phoneNumber
            newOrderTime.text = order.orderDate
            newOrderBranch.text = "Киевская, 12"
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