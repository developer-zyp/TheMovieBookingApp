package com.zyp.padc.themoviebookingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.delegates.TicketViewHolderDelegate
import com.zyp.padc.themoviebookingapp.viewholders.TicketViewHolder

class TicketAdapter(private val mDelegate: TicketViewHolderDelegate) :
    RecyclerView.Adapter<TicketViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_ticket, parent, false)
        return TicketViewHolder(itemView, mDelegate)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }
}