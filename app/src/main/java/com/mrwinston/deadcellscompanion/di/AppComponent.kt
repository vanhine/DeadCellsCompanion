package com.mrwinston.deadcellscompanion.di

import com.mrwinston.deadcellscompanion.view.MainActivity
import com.mrwinston.deadcellscompanion.view.fragments.*
import com.mrwinston.deadcellscompanion.viewmodel.GearViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(viewModel: GearViewModel)
    fun inject(fragment: GrenadesFragment)
    fun inject(fragment: MeleeWeaponsFragment)
    fun inject(fragment: PowersFragment)
    fun inject(fragment: RangedWeaponsFragment)
    fun inject(fragment: ShieldsFragment)
    fun inject(fragment: TrapsFragment)
    fun inject(fragment: WeaponsFragment)
}