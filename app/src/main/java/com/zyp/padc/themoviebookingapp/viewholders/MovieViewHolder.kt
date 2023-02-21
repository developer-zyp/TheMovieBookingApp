package com.zyp.padc.themoviebookingapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.delegates.MovieViewHolderDelegate

class MovieViewHolder(
    itemView: View,
    private val mDelegate: MovieViewHolderDelegate,
    isComingSoon: Boolean
) :
    RecyclerView.ViewHolder(itemView) {

    init {

        itemView.setOnClickListener {
            mDelegate.onTapMovie(isComingSoon)
        }

    }

}