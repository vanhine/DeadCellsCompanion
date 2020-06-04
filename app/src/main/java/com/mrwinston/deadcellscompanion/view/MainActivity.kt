package com.mrwinston.deadcellscompanion.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.mrwinston.deadcellscompanion.MyApplication
import com.mrwinston.deadcellscompanion.R
import com.mrwinston.deadcellscompanion.di.AppComponent
import com.mrwinston.deadcellscompanion.view.fragments.*
import javax.inject.Inject

class MainActivity : FragmentActivity() {
    @Inject
    lateinit var auth: FirebaseAuth
    private lateinit var bottomNavigationView: BottomNavigationView
    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = (applicationContext as MyApplication).appComponent
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
    }

    override fun onStart() {
        super.onStart()
        loadFragment()
        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signedInAnonymously:success")
                    loadFragment()
                } else {
                    Log.d(TAG, "Failed to login anonymously", task.exception)
                    Toast.makeText(this, "Could Not authenticate", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun loadFragment() {
        val fragmentManager = supportFragmentManager
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val fragment = when (it.itemId) {
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
        bottomNavigationView.selectedItemId =
            R.id.bottom_nav_weapons
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
