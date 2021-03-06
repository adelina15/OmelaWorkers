package com.example.omelaworkers.view.courier.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.omelaworkers.R
import com.example.omelaworkers.data.model.Bouquet
import com.example.omelaworkers.databinding.FlowerItemBinding

class DetailsAdapter(): RecyclerView.Adapter<DetailsAdapter.FlowersViewHolder>() {

    private var list = listOf<Bouquet>()
    fun setList (list : List<Bouquet>){
        this.list = list
        notifyDataSetChanged()
    }

    class FlowersViewHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = FlowerItemBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(flowers: Bouquet) = with(binding) {
            flowerName.text = flowers.name
            flowerDiscount.text = (if (flowers.discount == null) {""} else {"-${flowers.discount}%"})
            Glide.with(itemView.context).load(flowers.photo).into(flowerImage)
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