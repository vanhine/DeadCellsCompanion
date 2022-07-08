package com.mrwinston.deadcellsref.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.mrwinston.deadcellsref.MyApplication
import com.mrwinston.deadcellsref.R
import com.mrwinston.deadcellsref.di.AppComponent
import com.mrwinston.deadcellsref.view.fragments.*
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
                }
            }
    }

    private fun loadFragment() {
        val fragmentManager = supportFragmentManager
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            //TODO(hine): Add a loading progress bar
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
        private const val TAG = "MainActivity"
    }
}
