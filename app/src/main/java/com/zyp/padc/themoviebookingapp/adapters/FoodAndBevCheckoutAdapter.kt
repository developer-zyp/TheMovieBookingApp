package com.zyp.padc.themoviebookingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.viewholders.FoodAndBevCheckoutViewHolder

class FoodAndBevCheckoutAdapter : RecyclerView.Adapter<FoodAndBevCheckoutViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodAndBevCheckoutViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_fnb_checkout, parent, false)
        return FoodAndBevCheckoutViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodAndBevCheckoutViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 2
    }
}