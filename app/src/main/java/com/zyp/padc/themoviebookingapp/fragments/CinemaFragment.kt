package com.zyp.padc.themoviebookingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.activities.ChooseSeatActivity
import com.zyp.padc.themoviebookingapp.activities.SearchCinemaActivity
import com.zyp.padc.themoviebookingapp.adapters.CinemaAdapter
import com.zyp.padc.themoviebookingapp.delegates.ShowTimeViewHolderDelegate
import kotlinx.android.synthetic.main.activity_booking.*

class CinemaFragment : Fragment(), ShowTimeViewHolderDelegate {

    lateinit var mSearchCinemaAdapter: CinemaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cinema, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        setUpUI()

    }

    private fun setUpRecyclerView() {

        mSearchCinemaAdapter = CinemaAdapter(this)
        rvCinemaList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvCinemaList.adapter = mSearchCinemaAdapter


    }

    private fun setUpUI() {
        btnSearch.setOnClickListener {
            startActivity(SearchCinemaActivity.newIntent(requireContext()))
        }

    }

    override fun onLongTapShowTime() {
        startActivity(ChooseSeatActivity.newIntent(requireContext()))
    }

}