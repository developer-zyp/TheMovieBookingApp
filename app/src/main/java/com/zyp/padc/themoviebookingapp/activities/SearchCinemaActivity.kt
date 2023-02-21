package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.adapters.CinemaAdapter
import com.zyp.padc.themoviebookingapp.delegates.ShowTimeViewHolderDelegate
import kotlinx.android.synthetic.main.activity_search_cinema.*

class SearchCinemaActivity : AppCompatActivity(), ShowTimeViewHolderDelegate {

    lateinit var mSearchCinemaAdapter: CinemaAdapter

    var facilitiesList = arrayOf("Facilities", "Parking", "Online Food", "Wheel Chair ")
    var formatList = arrayOf("Format", "2D", "3D", "3D IMAX", "3d DBOX")

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, SearchCinemaActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_cinema)

        setUpFilerSpinner()
        setUpRecyclerView()
        setUpUI()

    }

    private fun setUpFilerSpinner() {
        val facilitiesAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.layout_spinner_item,
            facilitiesList
        )
        facilitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnFilerFacilities.adapter = facilitiesAdapter

        val formatAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.layout_spinner_item,
            formatList
        )
        formatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnFilerFormat.adapter = formatAdapter
    }

    private fun setUpRecyclerView() {
        mSearchCinemaAdapter = CinemaAdapter(this)
        rvSearchCinemaList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        rvSearchCinemaList.adapter = mSearchCinemaAdapter
    }

    override fun onLongTapShowTime() {
        startActivity(ChooseSeatActivity.newIntent(this))
    }

    private fun setUpUI() {
        btnBack.setOnClickListener { super.onBackPressed() }

        edtSearchCinema.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH
                || actionId == EditorInfo.IME_ACTION_DONE
                || keyEvent.action == KeyEvent.ACTION_DOWN
                && keyEvent.keyCode == KeyEvent.KEYCODE_ENTER
            ) {

                rvSearchCinemaList.adapter = mSearchCinemaAdapter
                return@setOnEditorActionListener true
            }

            return@setOnEditorActionListener false
        }

    }


}