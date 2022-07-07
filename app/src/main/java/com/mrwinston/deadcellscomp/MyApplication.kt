package com.mrwinston.deadcellscomp

import android.app.Application
import com.mrwinston.deadcellscomp.di.AppComponent
import com.mrwinston.deadcellscomp.di.DaggerAppComponent

open class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create()
    }
}