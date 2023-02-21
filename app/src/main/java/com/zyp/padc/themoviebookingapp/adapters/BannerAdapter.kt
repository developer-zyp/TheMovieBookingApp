package com.zyp.padc.themoviebookingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.delegates.BannerViewHolderDelegate
import com.zyp.padc.themoviebookingapp.viewholders.BannerViewHolder

class BannerAdapter(private val mDelegate: BannerViewHolderDelegate) :
    RecyclerView.Adapter<BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_banner, parent, false)
        return BannerViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 4
    }
}