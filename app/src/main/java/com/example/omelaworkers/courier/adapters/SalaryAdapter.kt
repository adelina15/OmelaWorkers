package com.example.omelaworkers.courier.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omelaworkers.R
import com.example.omelaworkers.courier.model.Salary
import com.example.omelaworkers.databinding.SalaryItemBinding

class SalaryAdapter: RecyclerView.Adapter<SalaryAdapter.SalaryHolder>() {

    private var list = mutableListOf<Salary>()
    fun setList (list : MutableList<Salary>){
        this.list = list
    }

    class SalaryHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = SalaryItemBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(salary: Salary) = with(binding) {
            date.text = salary.date
            ordersCount.text = salary.ordersCount.toString()
            salaryForDay.text = "${salary.salary} c"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalaryHolder {
        val view = LayoutInflater.from((parent.context)).inflate(R.layout.salary_item, parent, false)
        return SalaryHolder(view)
    }

    override fun onBindViewHolder(holder: SalaryHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}