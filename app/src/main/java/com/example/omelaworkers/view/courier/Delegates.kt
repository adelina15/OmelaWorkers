package com.example.omelaworkers.view.courier

import com.example.omelaworkers.data.model.CurrentOrder
import com.example.omelaworkers.data.model.OrdersItem

interface Delegates {
    interface OrderClicked{
        fun onItemClick(order: OrdersItem)
    }
    interface CurrentOrderClicked{
        fun onItemClick(order: CurrentOrder)
    }
}