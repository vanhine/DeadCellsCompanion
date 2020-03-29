package com.mrwinston.deadcellscompanion

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mrwinston.deadcellscompanion.fragments.*

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val fragmentManager = supportFragmentManager
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val fragment = when(it.itemId) {
                R.id.bottom_nav_weapons -> WeaponsFragment()
                R.id.bottom_nav_shields -> ShieldsFragment()
                R.id.bottom_nav_grenades -> GrenadesFragment()
                R.id.bottom_nav_traps -> TrapsFragment()
                R.id.bottom_nav_powers -> PowersFragment()
                else -> WeaponsFragment()
            }
            fragmentTransaction.replace(R.id.main_view_frame, fragment)
            fragmentTransaction.commit()
            true
        }
        bottomNavigationView.selectedItemId = R.id.bottom_nav_weapons
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
