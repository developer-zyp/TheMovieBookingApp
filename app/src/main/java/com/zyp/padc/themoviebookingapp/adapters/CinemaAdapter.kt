package com.zyp.padc.themoviebookingapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.activities.CinemaDetailsActivity
import com.zyp.padc.themoviebookingapp.delegates.ShowTimeViewHolderDelegate
import com.zyp.padc.themoviebookingapp.viewholders.CinemaViewHolder
import kotlinx.android.synthetic.main.view_holder_cinema.view.*

class CinemaAdapter(val mDelegate: ShowTimeViewHolderDelegate) :
    RecyclerView.Adapter<CinemaViewHolder>() {

    lateinit var mShowTimeAdapter: ShowTimeAdapter
    private var currentIndex = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_cinema, parent, false)
        return CinemaViewHolder(itemView)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {

        mShowTimeAdapter = ShowTimeAdapter(mDelegate)
        holder.itemView.apply {
            rvShowTimeList.layoutManager = GridLayoutManager(context, 3)
            rvShowTimeList.adapter = mShowTimeAdapter

            this.setOnClickListener {
                currentIndex = if (currentIndex == position) -1 else position
                notifyDataSetChanged()
            }

            tvCinemaDetails.setOnClickListener {
                context.startActivity(CinemaDetailsActivity.newIntent(context))
            }

            if (currentIndex == position) {
                rlShowTime.visibility = View.VISIBLE
            } else {
                rlShowTime.visibility = View.GONE
            }


        }


    }

    override fun getItemCount(): Int {
        return 5
    }
}