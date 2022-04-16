package com.example.omelaworkers.view.florist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omelaworkers.R
import com.example.omelaworkers.databinding.BouquetBinding
import com.example.omelaworkers.data.model.Bouquet

class BouquetAdapter: RecyclerView.Adapter<BouquetAdapter.BouquetHolder>()  {

    private var list = mutableListOf<Bouquet>()
    fun setList (list : MutableList<Bouquet>){
        this.list = list
    }

    class BouquetHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = BouquetBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(bouquet: Bouquet) = with(binding) {
            bouquetName.text = bouquet.name
            bouquetPrice.text = "${bouquet.price} c"
//            salary.text = "${bouquet.salary} c"
//            bouquetCategory.text = bouquet.category
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BouquetHolder {
        val view = LayoutInflater.from((parent.context)).inflate(R.layout.bouquet, parent, false)
        return BouquetHolder(view)
    }

    override fun onBindViewHolder(holder: BouquetHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}