package com.zyp.padc.themoviebookingapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.delegates.BannerViewHolderDelegate

class BannerViewHolder(itemView: View, private val mDelegate: BannerViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            mDelegate.onTabBanner()
        }
    }

}