package com.zyp.padc.themoviebookingapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.viewholders.FoodAndBevViewHolder
import kotlinx.android.synthetic.main.view_holder_food_and_beverage.view.*

class FoodAndBevAdapter : RecyclerView.Adapter<FoodAndBevViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAndBevViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_food_and_beverage, parent, false)
        return FoodAndBevViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodAndBevViewHolder, position: Int) {
        holder.itemView.apply {

            btnFNBAdd.setOnClickListener {
                it.visibility = View.INVISIBLE
                llFNBQty.visibility = View.VISIBLE
            }

            btnPlusQty.setOnClickListener {
                val itemQty = tvFNBQty.text.toString().toInt()
                tvFNBQty.text = (itemQty + 1).toString()
            }

            btnMinusQty.setOnClickListener {
                val itemQty = tvFNBQty.text.toString().toInt()
                if (itemQty > 1) {
                    tvFNBQty.text = (itemQty - 1).toString()
                } else {
                    btnFNBAdd.visibility = View.VISIBLE
                    llFNBQty.visibility = View.INVISIBLE
                }

            }

        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}