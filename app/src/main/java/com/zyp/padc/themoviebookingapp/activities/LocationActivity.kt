package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.zyp.padc.themoviebookingapp.R
import kotlinx.android.synthetic.main.activity_location.*


class LocationActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LocationActivity::class.java)
        }

    }

    var cityList = arrayOf("Yangon", "Mandalay", "Naypyidaw", "Bago", "Mawlamyine")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        setUpUI()


    }

    private fun setUpUI() {
        val citiesAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            cityList
        )
        lvCities.adapter = citiesAdapter
        lvCities.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val city = parent.getItemAtPosition(position)
//                showSnackBar(city as String)
                startActivity(MainActivity.newIntent(this, city as String))
            }

        svLocation.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                citiesAdapter.filter.filter(newText)
                return true
            }
        })

        btnSearch.setOnClickListener {
            startActivity(MainActivity.newIntent(this, "Yangon"))
        }


    }

    private fun showSnackBar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
    }


}