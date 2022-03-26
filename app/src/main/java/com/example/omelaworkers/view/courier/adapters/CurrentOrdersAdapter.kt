package com.example.omelaworkers.view.courier.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omelaworkers.R
import com.example.omelaworkers.view.courier.Delegates
import com.example.omelaworkers.data.model.CurrentOrder
import com.example.omelaworkers.databinding.CurrentOrderBinding

class CurrentOrdersAdapter(private val currentOrderClicker: Delegates.CurrentOrderClicked) :
    RecyclerView.Adapter<CurrentOrdersAdapter.CurrentOrdersHolder>() {

    private var list = mutableListOf<CurrentOrder>()
    fun setList(list: MutableList<CurrentOrder>) {
        this.list = list
    }

    class CurrentOrdersHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CurrentOrderBinding.bind(item)
        fun bind(order: CurrentOrder) = with(binding) {
            status.text = order.order_status
            newClientName.text = order.client_name
            newClientAddress.text = order.client_address
            newClientNumber.text = order.client_number
            newOrderTime.text = order.order_time
            newOrderBranch.text = order.branch_address
//            button.setOnClickListener {
//                if (status.text == "принял") {
//                    button.apply {
//                        background = ContextCompat.getDrawable(
//                            context,
//                            R.drawable.button_peach
//                        )
//                        isEnabled = true
//                    }
//                    button.text = "доставил"
//                    status.text = "в пути"
//                    order.order_status = "в пути"
//                    Log.i("finished", "${order.order_status} should be omw1")
//                }
//                else if (status.text == "в пути") {
//                    Log.i("finished", "${order.order_status} should be omw")
//                    button.apply {
//                        background = ContextCompat.getDrawable(
//                            context,
//                            R.drawable.button_green
//                        )
//                        isEnabled = true
//                    }
//                    button.text = "завершил"
//                    status.text = "доставил"
//                    order.order_status = "доставил"
//                    Log.i("finished", "${order.order_status} should be delivered")
//                }
//                else if (status.text == "доставил") {
//                    order.order_status = "завершил"
//                    //send to finished orders
//                    Log.i("finished", "${order.order_status} finished")
//                }
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentOrdersHolder {
        val view = LayoutInflater.from((parent.context)).inflate(R.layout.current_order, parent, false)
        return CurrentOrdersHolder(view)
    }

    override fun onBindViewHolder(holder: CurrentOrdersHolder, position: Int) {
        holder.bind(list[position])
        holder.binding.layout.setOnClickListener {
            currentOrderClicker.onItemClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}