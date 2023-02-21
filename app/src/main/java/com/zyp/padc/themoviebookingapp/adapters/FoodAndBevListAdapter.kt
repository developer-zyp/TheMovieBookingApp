package com.zyp.padc.themoviebookingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.viewholders.FoodAndBevListViewHolder
import kotlinx.android.synthetic.main.view_holder_fnb_list.view.*

class FoodAndBevListAdapter : RecyclerView.Adapter<FoodAndBevListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAndBevListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_fnb_list, parent, false)
        return FoodAndBevListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodAndBevListViewHolder, position: Int) {
        holder.itemView.apply {
            btnPlusQty.setOnClickListener {
                val itemQty = tvFNBQty.text.toString().toInt() + 1
                tvFNBQty.text = itemQty.toString()
                tvFNBItemAmount.text = "${(itemQty * 1000)}Ks"
            }

            btnMinusQty.setOnClickListener {
                val itemQty = tvFNBQty.text.toString().toInt() - 1
                if (itemQty > 0) {
                    tvFNBQty.text = itemQty.toString()
                    tvFNBItemAmount.text = "${(itemQty * 1000)}Ks"
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}