package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyp.padc.themoviebookingapp.BuildConfig
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.adapters.CastAdapter
import kotlinx.android.synthetic.main.activity_movie_details.*


class MovieDetailsActivity : AppCompatActivity() {

    lateinit var mCastAdapter: CastAdapter

    companion object {

        private var isComingSoon = false

        fun newIntent(context: Context, isComingSoon: Boolean): Intent {
            this.isComingSoon = isComingSoon
            return Intent(context, MovieDetailsActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        setUpUI()
        setUpRecyclerView()

    }

    private fun setUpUI() {

//        val videoURL = "https://youtu.be/OCSnxXtjFL0"
//        val uri: Uri = Uri.parse(videoURL)
//        vdoView.setVideoURI(uri)
//        vdoView.start()

        val path = "android.resource://" + packageName + "/" + R.raw.video_gru
        vdoView.setVideoURI(Uri.parse(path))
        vdoView.setMediaController(MediaController(this))
        vdoView.start()

        rlReleasingDay.visibility = if (isComingSoon) View.VISIBLE else View.GONE
        btnBooking.visibility = if (!isComingSoon) View.VISIBLE else View.GONE
        btnBooking.setOnClickListener {
            startActivity(BookingActivity.newIntent(this))
        }

        btnBack.setOnClickListener {
            super.onBackPressed()
        }

        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, resources.getString(R.string.app_name))
            val appUrl =
                "https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
            shareIntent.putExtra(Intent.EXTRA_TEXT, appUrl)
            startActivity(Intent.createChooser(shareIntent, "Share App via"))
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            nsvMovieDetails.setOnScrollChangeListener { nestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY > oldScrollY) {
                    btnBooking.visibility = View.GONE
                    val animate = TranslateAnimation(0F, 0F, 0F, btnBooking.height.toFloat() + 50)
                    animate.duration = 100
                    btnBooking.startAnimation(animate)
                } else {
                    btnBooking.visibility = View.VISIBLE
                    val animate = TranslateAnimation(0F, 0F, btnBooking.height.toFloat() + 50, 0F)
                    animate.duration = 100
                    animate.fillAfter = true
                    btnBooking.startAnimation(animate)
                }
            }
        }

    }

    private fun setUpRecyclerView() {
        mCastAdapter = CastAdapter()
        rvCastList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCastList.adapter = mCastAdapter

    }
}