package com.example.omelaworkers.view.florist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.omelaworkers.R
import com.example.omelaworkers.databinding.FlowerInfoBinding
import com.example.omelaworkers.data.model.Flower

class FlowerAdapter: RecyclerView.Adapter<FlowerAdapter.FloweryHolder>()  {

    private var list = listOf<Flower>()
    fun setList (list : List<Flower>){
        this.list = list
        notifyDataSetChanged()
    }

    class FloweryHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = FlowerInfoBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(flower: Flower) = with(binding) {
            name.text = flower.name
            flowerPrice.text = "${flower.price} c"
            flowerCount.text = "${flower.quantity} шт"
            Glide.with(itemView.context).load(flower.photo).into(flowerImage)
//            flowerHeight.text = "${flower.height} см"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FloweryHolder {
        val view = LayoutInflater.from((parent.context)).inflate(R.layout.flower_info, parent, false)
        return FloweryHolder(view)
    }

    override fun onBindViewHolder(holder: FloweryHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}