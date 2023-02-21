package com.zyp.padc.themoviebookingapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.delegates.TicketViewHolderDelegate

class TicketViewHolder(itemView: View, private val mDelegate: TicketViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            mDelegate.onTapTicket()
        }
    }

}