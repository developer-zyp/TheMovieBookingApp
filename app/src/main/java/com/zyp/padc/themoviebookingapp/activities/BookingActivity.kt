package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.adapters.CinemaAdapter
import com.zyp.padc.themoviebookingapp.adapters.DateCardAdapter
import com.zyp.padc.themoviebookingapp.delegates.ShowTimeViewHolderDelegate
import kotlinx.android.synthetic.main.activity_booking.*

class BookingActivity : AppCompatActivity(), ShowTimeViewHolderDelegate {

    lateinit var mDateCardAdapter: DateCardAdapter
    lateinit var mCinemaAdapter: CinemaAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, BookingActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        setUpToolBar()
        setUpRecyclerView()
        setUpUI()

    }


    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24)
    }

    private fun setUpRecyclerView() {
        mDateCardAdapter = DateCardAdapter(this)
        rvDateCardList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvDateCardList.adapter = mDateCardAdapter

        mCinemaAdapter = CinemaAdapter(this)
        rvCinemaList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvCinemaList.adapter = mCinemaAdapter


    }

    private fun setUpUI() {
        btnSearch.setOnClickListener {
            startActivity(SearchCinemaActivity.newIntent(this))
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onLongTapShowTime() {
        startActivity(ChooseSeatActivity.newIntent(this))
    }

}