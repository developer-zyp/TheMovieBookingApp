package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.zyp.padc.themoviebookingapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    var countryCodeList = arrayOf("+95", "+63", "+65", "+66", "+84")

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpUI()

    }

    private fun setUpUI() {

        btnVerifyPhoneNumber.setOnClickListener {
            startActivity(VerifyOtpActivity.newIntent(this))
        }

        val countryCodeAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.layout_spinner_item_login,
            countryCodeList
        )
        countryCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCountryCode.adapter = countryCodeAdapter

    }
}