package com.zyp.padc.themoviebookingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.viewholders.SeatingViewHolder
import kotlinx.android.synthetic.main.view_holder_seat.view.*

class SeatingAdapter : RecyclerView.Adapter<SeatingViewHolder>() {

    private val VIEW_TYPE_SEAT_TYPE = 1
    private val VIEW_TYPE_SEAT = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatingViewHolder {
        val itemView =
            when (viewType) {
                VIEW_TYPE_SEAT_TYPE -> {
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_seat_type, parent, false)
                }
                VIEW_TYPE_SEAT -> {
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_seat, parent, false)
                }
                else -> {
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_seat, parent, false)
                }
            }

        return SeatingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SeatingViewHolder, position: Int) {
        holder.itemView.apply {
            if (getItemViewType(position) == VIEW_TYPE_SEAT) {
                ivSeat1.setOnClickListener {
                    onSeatClick(ivSeat1, context)
                }
                ivSeat2.setOnClickListener {
                    onSeatClick(ivSeat2, context)
                }
                ivSeat3.setOnClickListener {
                    onSeatClick(ivSeat3, context)
                }
                ivSeat4.setOnClickListener {
                    onSeatClick(ivSeat4, context)
                }
                ivSeat5.setOnClickListener {
                    onSeatClick(ivSeat5, context)
                }
                ivSeat6.setOnClickListener {
                    onSeatClick(ivSeat6, context)
                }
                ivSeat7.setOnClickListener {
                    onSeatClick(ivSeat7, context)
                }
                ivSeat8.setOnClickListener {
                    onSeatClick(ivSeat8, context)
                }

            }
        }

    }

    override fun getItemCount(): Int {
        return 15
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            (position % 3 == 0) -> {
                VIEW_TYPE_SEAT_TYPE
            }
            else -> {
                VIEW_TYPE_SEAT
            }
        }
    }

    private fun onSeatClick(ivSeat: AppCompatImageView, context: Context) {
        ivSeat.tag = if (ivSeat.tag == 0) 1 else 0
        ivSeat.imageTintList = if (ivSeat.tag == 0)
            context.resources.getColorStateList(R.color.colorAccent)
        else
            context.resources.getColorStateList(R.color.white)
    }

}