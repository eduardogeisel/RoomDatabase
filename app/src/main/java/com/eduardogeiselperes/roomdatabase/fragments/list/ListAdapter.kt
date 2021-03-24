package com.eduardogeiselperes.roomdatabase.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eduardogeiselperes.roomdatabase.R
import com.eduardogeiselperes.roomdatabase.model.Vehicle
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var vehicleList = emptyList<Vehicle>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return vehicleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = vehicleList[position]
        holder.itemView.tv_id.text = currentItem.id.toString()
        holder.itemView.tv_make.text = currentItem.make
        holder.itemView.tv_model.text = currentItem.model
        holder.itemView.tv_year.text = currentItem.year.toString()
    }

    fun setData(vehicle: List<Vehicle>){
        this.vehicleList = vehicle
        notifyDataSetChanged()
    }
}