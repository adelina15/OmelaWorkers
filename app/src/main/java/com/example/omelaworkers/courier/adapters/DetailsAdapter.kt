package com.example.omelaworkers.courier.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omelaworkers.R
import com.example.omelaworkers.courier.model.OrderFlower
import com.example.omelaworkers.databinding.FlowerItemBinding

class DetailsAdapter(): RecyclerView.Adapter<DetailsAdapter.FlowersViewHolder>() {

    private var list = mutableListOf<OrderFlower>()
    fun setList (list : MutableList<OrderFlower>){
        this.list = list
    }

    class FlowersViewHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = FlowerItemBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(flowers: OrderFlower) = with(binding) {
            flowerName.text = flowers.name
            flowerDiscount.text = (if (flowers.discount == null) {""} else {"-${flowers.discount}%"})
            flowerImage.setImageResource(flowers.image)
            flowerPrice.text = "${flowers.price} с"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowersViewHolder {
        val view = LayoutInflater.from((parent.context)).inflate(R.layout.flower_item, parent, false)
        return FlowersViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlowersViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}