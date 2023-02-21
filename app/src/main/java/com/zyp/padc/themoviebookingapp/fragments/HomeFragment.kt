package com.zyp.padc.themoviebookingapp.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.activities.MovieDetailsActivity
import com.zyp.padc.themoviebookingapp.activities.SearchMovieActivity
import com.zyp.padc.themoviebookingapp.adapters.BannerAdapter
import com.zyp.padc.themoviebookingapp.adapters.MovieAdapter
import com.zyp.padc.themoviebookingapp.delegates.BannerViewHolderDelegate
import com.zyp.padc.themoviebookingapp.delegates.MovieViewHolderDelegate
import com.zyp.padc.themoviebookingapp.viewpods.MovieListViewPod
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), BannerViewHolderDelegate, MovieViewHolderDelegate {

    lateinit var mBannerAdapter: BannerAdapter
    lateinit var mMovieAdapter: MovieAdapter
    lateinit var mMovieListViewPod: MovieListViewPod
    private var isComingSoon = false

    val sliderHandler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBannerViewPager()
        setUpTabLayout()
        setUpRecyclerView()
        setUpUI()
//        setUpViewPods()

    }


    private fun setUpRecyclerView() {
        mMovieAdapter = MovieAdapter(this, false)
        rvNowShowingMovieList.adapter = mMovieAdapter
        rvNowShowingMovieList.layoutManager = GridLayoutManager(context, 2)

        mMovieAdapter = MovieAdapter(this, true)
        rvComingSoonMovieList.adapter = mMovieAdapter
        rvComingSoonMovieList.layoutManager = GridLayoutManager(context, 2)
        rvComingSoonMovieList.visibility = View.GONE
    }

    private fun setUpTabLayout() {
        val tab1 = tabLayoutHome.newTab()
        tab1.text = resources.getString(R.string.lbl_now_showing)
        tabLayoutHome.addTab(tab1)

        val tab2 = tabLayoutHome.newTab()
        tab2.text = resources.getString(R.string.lbl_coming_soon)
        tabLayoutHome.addTab(tab2)

        tabLayoutHome.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    when (tab.position) {
                        0 -> {
                            isComingSoon = false
                            rvNowShowingMovieList.visibility = View.VISIBLE
                            rvComingSoonMovieList.visibility = View.GONE
                        }
                        1 -> {
                            isComingSoon = true
                            rvNowShowingMovieList.visibility = View.GONE
                            rvComingSoonMovieList.visibility = View.VISIBLE
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


    }

    private fun setUpBannerViewPager() {
        mBannerAdapter = BannerAdapter(this)
        viewPagerBanner.adapter = mBannerAdapter
//        viewPagerBanner.clipToPadding = false
//        viewPagerBanner.clipChildren = false
//        viewPagerBanner.offscreenPageLimit = 3
//        viewPagerBanner.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
//
//        val compositePageTransformer = CompositePageTransformer()
//        compositePageTransformer.addTransformer(MarginPageTransformer(40))
//        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { page, position ->
//            val r = 1 - abs(position)
//            page.scaleY = 0.85f + r * 0.15f;
//        })
//
//        viewPagerBanner.setPageTransformer(compositePageTransformer)
//        viewPagerBanner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                sliderHandler.removeCallbacks(sliderRunnable)
//                sliderHandler.postDelayed(sliderRunnable, 3000) // slide duration 2s
//            }
//        })
//
//        dotsIndicatorBanner.attachTo(viewPagerBanner)

    }

//    private val sliderRunnable =
//        Runnable { viewPagerBanner.currentItem = viewPagerBanner.currentItem + 1 }


    private fun setUpUI() {
        btnSearchMovie.setOnClickListener {
            startActivity(SearchMovieActivity.newIntent(requireContext(), isComingSoon))
        }
    }


    private fun setUpViewPods() {
        mMovieListViewPod = vpNowShowingMovieList as MovieListViewPod
        mMovieListViewPod.setUpMovieListViewPod(this)
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
    }

    override fun onTapMovie(isComingSoon: Boolean) {
//        showSnackBar("Tapped Movie")
        startActivity(MovieDetailsActivity.newIntent(requireContext(), isComingSoon))
    }

    override fun onTabBanner() {
//        showSnackBar("Tapped Banner")
    }


}