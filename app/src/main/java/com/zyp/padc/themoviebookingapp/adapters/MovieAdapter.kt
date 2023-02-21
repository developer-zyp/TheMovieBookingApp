package com.zyp.padc.themoviebookingapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.delegates.MovieViewHolderDelegate
import com.zyp.padc.themoviebookingapp.viewholders.MovieViewHolder
import kotlinx.android.synthetic.main.view_holder_movie.view.*

class MovieAdapter(
    private val mDelegate: MovieViewHolderDelegate,
    private val isComingSoon: Boolean
) :
    RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        return MovieViewHolder(view, mDelegate, isComingSoon)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.itemView.tvReleasingDate.visibility = if (isComingSoon) View.VISIBLE else View.GONE

    }

    override fun getItemCount(): Int {
        return 10
    }
}