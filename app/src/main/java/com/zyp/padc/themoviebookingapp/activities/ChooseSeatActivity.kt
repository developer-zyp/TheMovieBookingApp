package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.adapters.SeatingAdapter
import kotlinx.android.synthetic.main.activity_choose_seat.*

class ChooseSeatActivity : AppCompatActivity() {

    lateinit var mSeatingAdapter: SeatingAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ChooseSeatActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_seat)

        setUpToolBar()
        setUpRecyclerView()
        setUpUI()

    }

    private fun setUpToolBar() {
        toolBar.title = ""
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24)
    }


    private fun setUpUI() {
        btnBooking.setOnClickListener {
            startActivity(FoodAndBeverageActivity.newIntent(this))
        }


    }

    private fun setUpRecyclerView() {
        mSeatingAdapter = SeatingAdapter()
        rvCinemaSeating.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvCinemaSeating.adapter = mSeatingAdapter

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

}