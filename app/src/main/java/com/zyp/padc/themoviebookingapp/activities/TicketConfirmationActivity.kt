package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.fragments.BookingSuccessFragment
import kotlinx.android.synthetic.main.activity_ticket_confirmation.*

class TicketConfirmationActivity : AppCompatActivity() {

    private val TAG_BookingSuccess = "BookingSuccess"

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, TicketConfirmationActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_confirmation)

        val bookingSuccessDialog = BookingSuccessFragment()
        bookingSuccessDialog.show(supportFragmentManager, TAG_BookingSuccess)

        btnDone.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)


        }

    }

}