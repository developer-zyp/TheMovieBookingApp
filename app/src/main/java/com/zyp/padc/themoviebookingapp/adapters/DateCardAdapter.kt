package com.zyp.padc.themoviebookingapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.viewholders.DateCardViewHolder
import kotlinx.android.synthetic.main.view_holder_date_card.view.*

class DateCardAdapter(val context: Context) : RecyclerView.Adapter<DateCardViewHolder>() {

    private var currentIndex = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateCardViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_date_card, parent, false)
        return DateCardViewHolder(itemView)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: DateCardViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            currentIndex = position
            notifyDataSetChanged();
        }

        if (currentIndex == position) {
            holder.itemView.ivDateCard.setImageDrawable(context.getDrawable(R.drawable.bg_date_card_active))
        } else {
            holder.itemView.ivDateCard.setImageDrawable(context.getDrawable(R.drawable.bg_date_card))
        }
    }

    override fun getItemCount(): Int {
        return 7
    }
}