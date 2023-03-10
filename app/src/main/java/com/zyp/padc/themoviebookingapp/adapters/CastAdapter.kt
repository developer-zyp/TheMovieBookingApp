package com.zyp.padc.themoviebookingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.viewholders.CastViewHolder

class CastAdapter : RecyclerView.Adapter<CastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_cast, parent, false)
        return CastViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 7
    }
}