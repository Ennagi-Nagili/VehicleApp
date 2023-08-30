package com.annaginagili.vehicle2

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.annaginagili.vehicle2.databinding.ActivityMainBinding
import com.annaginagili.vehicle2.databinding.VehicleLayoutBinding

class VehicleAdapter(private val context: Context, private val itemList: List<Vehicle>):
    RecyclerView.Adapter<VehicleAdapter.ItemHolder>() {
    class ItemHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        private val vehicleTypes: TextView = itemView!!.findViewById(R.id.vehicleTypes)
        fun setData(item: Vehicle, context: Context) {
            if (itemView.tag != null) {
                val binding =  VehicleLayoutBinding.bind(itemView)
                binding.viewData = item
            }
            var type = ""
            for (i in item.VehicleTypes!!) {
                type += i.Name + ", "
            }
            vehicleTypes.text = type

            itemView.setOnClickListener {
                val intent1 = Intent(context, DetailsActivity::class.java)
                if (item.Mfr_CommonName != null) {
                    intent1.putExtra("name", item.Mfr_CommonName)
                }
                else {
                    intent1.putExtra("name", item.Mfr_Name)
                }
                context.startActivity(intent1)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view: View? = LayoutInflater.from(context).inflate(R.layout.vehicle_layout, parent, false)
        return ItemHolder(view!!)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(itemList[position], context)
    }
}