package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.zyp.padc.themoviebookingapp.R
import kotlinx.android.synthetic.main.activity_cinema_details.*

class CinemaDetailsActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CinemaDetailsActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinema_details)

        setUpUI()

    }

    private fun setUpUI() {
        val path = "android.resource://" + packageName + "/" + R.raw.cinema_showcase
        vdoCinemaView.setVideoURI(Uri.parse(path))
        vdoCinemaView.setMediaController(MediaController(this))
        vdoCinemaView.start()
    }

}