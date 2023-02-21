package com.zyp.padc.themoviebookingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.delegates.ShowTimeViewHolderDelegate
import com.zyp.padc.themoviebookingapp.viewholders.ShowTimeViewHolder
import kotlinx.android.synthetic.main.view_holder_showtime.view.*

class ShowTimeAdapter(val mDelegate: ShowTimeViewHolderDelegate) :
    RecyclerView.Adapter<ShowTimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowTimeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_showtime, parent, false)
        return ShowTimeViewHolder(itemView, mDelegate)
    }

    override fun onBindViewHolder(holder: ShowTimeViewHolder, position: Int) {
        holder.itemView.apply {
            if (position == 1) {
                llShowTimeVH.backgroundTintList =
                    context.resources.getColorStateList(R.color.colorSecondaryText)

                for (view in llShowTimeVH.children) {
                    if (view is AppCompatTextView) {
                        view.setTextColor(context.resources.getColor(R.color.colorSecondaryText))
                    }
                }
//                tvShowTime.setTextColor(context.resources.getColor(R.color.colorSecondaryText))
            }

//            if (position == 2) {
//                llShowTimeVH.backgroundTintList =
//                    context.resources.getColorStateList(R.color.color_almost_full)
//            }
//
//            if (position == 3) {
//                llShowTimeVH.backgroundTintList =
//                    context.resources.getColorStateList(R.color.color_filling_fast)
//            }
        }
    }

    override fun getItemCount(): Int {
        return 5
    }
}