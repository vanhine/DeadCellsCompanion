package com.mrwinston.deadcellscompanion

import android.app.Application
import com.mrwinston.deadcellscompanion.di.AppComponent
import com.mrwinston.deadcellscompanion.di.DaggerAppComponent

open class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create()
    }
}