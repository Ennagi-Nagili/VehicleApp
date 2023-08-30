package com.annaginagili.vehicle2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.annaginagili.vehicle2.databinding.DetailsLayoutBinding

class DetailsAdapter(private val context: Context, private val itemList: List<Vehicle>):
    RecyclerView.Adapter<DetailsAdapter.ItemHolder>() {
    class ItemHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        fun setData(item: Vehicle, context: Context) {
            if (itemView.tag != null) {
                val binding =  DetailsLayoutBinding.bind(itemView)
                binding.viewData = item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view: View? = LayoutInflater.from(context).inflate(R.layout.details_layout, parent, false)
        return ItemHolder(view!!)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(itemList[position], context)
    }
}