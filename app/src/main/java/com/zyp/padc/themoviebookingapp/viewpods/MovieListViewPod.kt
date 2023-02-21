package com.zyp.padc.themoviebookingapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.zyp.padc.themoviebookingapp.adapters.MovieAdapter
import com.zyp.padc.themoviebookingapp.delegates.MovieViewHolderDelegate
import kotlinx.android.synthetic.main.view_pod_movie_list.view.*

class MovieListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    lateinit var mMovieAdapter: MovieAdapter
    lateinit var mDelegate: MovieViewHolderDelegate

    override fun onFinishInflate() {
//        setUpMovieRecyclerView()
        super.onFinishInflate()
    }

    fun setUpMovieListViewPod(delegate: MovieViewHolderDelegate) {
        setDelegate(delegate)
        setUpMovieRecyclerView()
    }

    private fun setDelegate(delegate: MovieViewHolderDelegate) {
        mDelegate = delegate
    }

    private fun setUpMovieRecyclerView() {
        mMovieAdapter = MovieAdapter(mDelegate, false)
        rvMovieList.adapter = mMovieAdapter
        rvMovieList.layoutManager = GridLayoutManager(context, 2)
    }

}