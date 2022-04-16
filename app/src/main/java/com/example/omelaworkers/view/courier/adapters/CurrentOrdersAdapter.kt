package com.example.omelaworkers.view.courier.adapters

import android.icu.text.DateFormat
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.omelaworkers.R
import com.example.omelaworkers.view.courier.Delegates
import com.example.omelaworkers.data.model.CurrentOrder
import com.example.omelaworkers.data.model.OrdersItem
import com.example.omelaworkers.databinding.CurrentOrderBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CurrentOrdersAdapter(private val currentOrderClicker: Delegates.OrderClicked) :
    RecyclerView.Adapter<CurrentOrdersAdapter.CurrentOrdersHolder>() {

    private var list = listOf<OrdersItem>()

    fun setList(newList: List<OrdersItem>){
        list = newList
        notifyDataSetChanged()
    }

    class CurrentOrdersHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CurrentOrderBinding.bind(item)
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(order: OrdersItem) = with(binding) {

            status.text = when(order.status){
                "COURIER_GO" -> "в пути"
                "COURIER_TAKE" -> "забрал"
                else -> "завершил"
            }
            newClientName.text = order.customerName
            newClientAddress.text = order.address
            newClientNumber.text = order.customer.phoneNumber
//            val timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.VVV'Z'")
            newOrderTime.text = order.orderDate
//                LocalDate.parse(order.orderDate, timeFormat).toString()
            newOrderBranch.text = "Киевская 12"
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