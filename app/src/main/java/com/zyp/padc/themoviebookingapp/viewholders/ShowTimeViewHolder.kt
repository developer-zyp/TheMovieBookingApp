package com.zyp.padc.themoviebookingapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.delegates.ShowTimeViewHolderDelegate

class ShowTimeViewHolder(itemView: View, private val mDelegate: ShowTimeViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnLongClickListener {
            mDelegate.onLongTapShowTime()
            return@setOnLongClickListener true
        }
    }

}