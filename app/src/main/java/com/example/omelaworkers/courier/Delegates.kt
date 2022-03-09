package com.example.omelaworkers.courier

import com.example.omelaworkers.courier.model.CurrentOrder
import com.example.omelaworkers.courier.model.NewOrder

interface Delegates {
    interface OrderClicked{
        fun onItemClick(order: NewOrder)
    }
    interface CurrentOrderClicked{
        fun onItemClick(order: CurrentOrder)
    }
}