package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zyp.padc.themoviebookingapp.R
import kotlinx.android.synthetic.main.activity_verify_otp.*

class VerifyOtpActivity : AppCompatActivity() {

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, VerifyOtpActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_otp)

        btnConfirmOtp.setOnClickListener {
            startActivity(LocationActivity.newIntent(this))
        }


    }
}