package com.zyp.padc.themoviebookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.zyp.padc.themoviebookingapp.R
import com.zyp.padc.themoviebookingapp.fragments.CinemaFragment
import com.zyp.padc.themoviebookingapp.fragments.HomeFragment
import com.zyp.padc.themoviebookingapp.fragments.ProfileFragment
import com.zyp.padc.themoviebookingapp.fragments.TicketFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private var location = "Yangon"
        fun newIntent(context: Context, city: String): Intent {
            location = city
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpBottomNav()

    }

    private fun setUpBottomNav() {
        switchFragment(HomeFragment())
        bottom_nav.setOnItemSelectedListener { menu: MenuItem ->
            when (menu.itemId) {
                R.id.menu_home -> {
                    switchFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.menu_cinema -> {
                    switchFragment(CinemaFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.menu_ticket -> {
                    switchFragment(TicketFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.menu_profile -> {
                    switchFragment(ProfileFragment())
                    return@setOnItemSelectedListener true
                }
            }

            false

        }
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutContainer, fragment)
            .commit()
    }

}