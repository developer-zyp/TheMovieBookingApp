package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zyp.padc.themoviebookingapp.R
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity(), View.OnClickListener {


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, PaymentActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        setUpToolBar()
        setUpUI()

    }

    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24)
    }

    private fun setUpUI() {
        btnPaymentUPI.setOnClickListener(this)
        btnPaymentGiftVoucher.setOnClickListener(this)
        btnPaymentQuickPay.setOnClickListener(this)
        btnPaymentCard.setOnClickListener(this)
        btnPaymentRedeemPoint.setOnClickListener(this)
        btnPaymentMobileWallet.setOnClickListener(this)
        btnPaymentNetBanking.setOnClickListener(this)

    }


    override fun onClick(view: View?) {
        startActivity(TicketConfirmationActivity.newIntent(this))

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