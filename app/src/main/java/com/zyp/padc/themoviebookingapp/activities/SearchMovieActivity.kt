package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.adapters.MovieAdapter
import com.zyp.padc.themoviebookingapp.delegates.MovieViewHolderDelegate
import kotlinx.android.synthetic.main.activity_search_movie.*


class SearchMovieActivity : AppCompatActivity(), MovieViewHolderDelegate {

    lateinit var mSearchMovieAdapter: MovieAdapter
    var genreList = arrayOf("Genres", "Action", "Adventure", "Drama", "Crime", "Animation")
    var formatList = arrayOf("Format", "2D", "3D", "3D IMAX", "3d DBOX")
    var monthList = arrayOf("Month", "Jan", "Feb", "March", "Apr", "May")

    companion object {

        private var isComingSoon = false

        fun newIntent(context: Context, isComingSoon: Boolean): Intent {
            this.isComingSoon = isComingSoon
            return Intent(context, SearchMovieActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        setUpFilerSpinner()
        setUpRecyclerView()
        setUpUI()

    }


    private fun setUpFilerSpinner() {
        val genresAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.layout_spinner_item,
            genreList
        )
        genresAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnFilerGenres.adapter = genresAdapter

        val formatAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.layout_spinner_item,
            formatList
        )
        formatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnFilerFormat.adapter = formatAdapter

        if (isComingSoon) {
            val monthAdapter: ArrayAdapter<String> = ArrayAdapter(
                this,
                R.layout.layout_spinner_item,
                monthList
            )
            monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnFilerMonth.adapter = monthAdapter
            spnFilerMonth.visibility = View.VISIBLE
        } else {
            spnFilerMonth.visibility = View.GONE
        }

    }

    private fun setUpRecyclerView() {
        mSearchMovieAdapter = MovieAdapter(this, isComingSoon)
//        rvSearchMovieList.adapter = mSearchMovieAdapter
        rvSearchMovieList.layoutManager = GridLayoutManager(this, 2)

    }


    private fun setUpUI() {
        btnBack.setOnClickListener { super.onBackPressed() }

        edtSearchMovie.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH
                || actionId == EditorInfo.IME_ACTION_DONE
                || keyEvent.action == KeyEvent.ACTION_DOWN
                && keyEvent.keyCode == KeyEvent.KEYCODE_ENTER
            ) {

                rvSearchMovieList.adapter = mSearchMovieAdapter
                return@setOnEditorActionListener true
            }

            return@setOnEditorActionListener false
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

    override fun onTapMovie(isComingSoon: Boolean) {
        startActivity(MovieDetailsActivity.newIntent(this, isComingSoon))
    }

}