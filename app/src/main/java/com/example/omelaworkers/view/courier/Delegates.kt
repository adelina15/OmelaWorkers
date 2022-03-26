package com.example.omelaworkers.view.courier

import com.example.omelaworkers.data.model.CurrentOrder
import com.example.omelaworkers.data.model.NewOrder

interface Delegates {
    interface OrderClicked{
        fun onItemClick(order: NewOrder)
    }
    interface CurrentOrderClicked{
        fun onItemClick(order: CurrentOrder)
    }
}