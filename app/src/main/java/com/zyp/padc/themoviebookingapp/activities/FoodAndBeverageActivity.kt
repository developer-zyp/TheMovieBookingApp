package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.adapters.FoodAndBevAdapter
import com.zyp.padc.themoviebookingapp.adapters.FoodAndBevListAdapter
import com.zyp.padc.themoviebookingapp.adapters.SpaceItemDecoration
import kotlinx.android.synthetic.main.activity_food_and_beverage.*
import kotlinx.android.synthetic.main.layout_fnb_bottom_sheet.view.*

class FoodAndBeverageActivity : AppCompatActivity() {

    private lateinit var mFoodAndBevAdapter: FoodAndBevAdapter
    private lateinit var mFoodAndBevListAdapter: FoodAndBevListAdapter
    private val NUM_COLUMNS = 2

    private val dummyTabs =
        listOf("All", "Combo", "Snack", "Pop Corn", "Beverage")

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, FoodAndBeverageActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_and_beverage)

        setUpToolBar()
        setUpFoodAndBeverageTabLayout()
        setUpRecyclerView()
        setUpBottomSheet()
        setUpUI()

    }

    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24)
    }

    private fun setUpFoodAndBeverageTabLayout() {
        dummyTabs.forEach {
            tabLayoutFoodAndBev.newTab().apply {
                text = it
                tabLayoutFoodAndBev.addTab(this)
            }
        }
    }

    private fun setUpRecyclerView() {
        mFoodAndBevAdapter = FoodAndBevAdapter()
        rvFoodAndBeverage.layoutManager = GridLayoutManager(this, NUM_COLUMNS)
        val itemDecoration = SpaceItemDecoration(dpToPx(16), true)
        rvFoodAndBeverage.addItemDecoration(itemDecoration)
        rvFoodAndBeverage.adapter = mFoodAndBevAdapter

    }

    private fun setUpBottomSheet() {
        mFoodAndBevListAdapter = FoodAndBevListAdapter()
        layoutBottomSheet.rvFoodAndBeverageList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        layoutBottomSheet.rvFoodAndBeverageList.adapter = mFoodAndBevListAdapter

        val bottomSheet = BottomSheetBehavior.from(layoutBottomSheet)

        ivFoodNBev.setOnClickListener {
            when (bottomSheet.state) {
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
                    ivExpendFood.setImageDrawable(resources.getDrawable(R.drawable.ic_arrow_up_black_24))
                }
                else -> {
                    bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
                    ivExpendFood.setImageDrawable(resources.getDrawable(R.drawable.ic_arrow_down_black_24))
                }
            }
        }
    }

    private fun setUpUI() {
        ivNextFood.setOnClickListener {
            startActivity(CheckoutActivity.newIntent(this))
        }

        btnSkip.setOnClickListener {
            startActivity(CheckoutActivity.newIntent(this))
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

    private fun dpToPx(dp: Int) = (resources.displayMetrics.density * dp).toInt()

}