package com.zyp.padc.themoviebookingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.activities.TicketDetailsActivity
import com.zyp.padc.themoviebookingapp.adapters.TicketAdapter
import com.zyp.padc.themoviebookingapp.delegates.TicketViewHolderDelegate
import kotlinx.android.synthetic.main.fragment_ticket.*

class TicketFragment : Fragment(), TicketViewHolderDelegate {

    lateinit var mTicketAdapter: TicketAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }


    private fun setUpRecyclerView() {
        mTicketAdapter = TicketAdapter(this)
        rvTicketList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvTicketList.adapter = mTicketAdapter

    }

    override fun onTapTicket() {
        startActivity(TicketDetailsActivity.newIntent(requireContext()))
    }


}