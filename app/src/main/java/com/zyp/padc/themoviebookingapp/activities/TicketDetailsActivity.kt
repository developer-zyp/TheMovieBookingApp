package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.adapters.FoodAndBevCheckoutAdapter
import com.zyp.padc.themoviebookingapp.fragments.CancellationPolicyFragment
import kotlinx.android.synthetic.main.activity_ticket_details.*

class TicketDetailsActivity : AppCompatActivity() {

    lateinit var mFoodAndBevCheckoutAdapter: FoodAndBevCheckoutAdapter
    val TAG_CancellationPolicy = "CancellationPolicyFragment"

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, TicketDetailsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_details)

        setUpRecyclerView()
        setUpUI()

    }

    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24)
    }

    private fun setUpRecyclerView() {
        mFoodAndBevCheckoutAdapter = FoodAndBevCheckoutAdapter()
        rvFNBItems.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvFNBItems.adapter = mFoodAndBevCheckoutAdapter

    }

    private fun setUpUI() {
        btnCancellationPolicy.setOnClickListener {
            val cancellationPolicyDialog = CancellationPolicyFragment()
            cancellationPolicyDialog.show(supportFragmentManager, TAG_CancellationPolicy)
        }

        btnCancelBooking.setOnClickListener {
            Toast.makeText(this, "Ticket Cancelled!", Toast.LENGTH_SHORT).show()
            super.onBackPressed()
        }

        ivExpendFNB.setOnClickListener {
            if (rvFNBItems.visibility == View.VISIBLE) {
                rvFNBItems.visibility = View.GONE
                ivExpendFNB.setImageDrawable(resources.getDrawable(R.drawable.ic_arrow_down_black_24))
            } else {
                rvFNBItems.visibility = View.VISIBLE
                ivExpendFNB.setImageDrawable(resources.getDrawable(R.drawable.ic_arrow_up_black_24))
            }
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
}