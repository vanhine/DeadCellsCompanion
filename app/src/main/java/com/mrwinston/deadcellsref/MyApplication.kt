package com.mrwinston.deadcellsref

import android.app.Application
import com.mrwinston.deadcellsref.di.AppComponent
import com.mrwinston.deadcellsref.di.DaggerAppComponent

open class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create()
    }
}