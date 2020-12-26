package com.mrwinston.deadcellscompanion.di

import com.mrwinston.deadcellscompanion.data.repository.GearRepositoryImpl
import com.mrwinston.deadcellscompanion.view.MainActivity
import com.mrwinston.deadcellscompanion.view.fragments.*
import com.mrwinston.deadcellscompanion.viewmodel.GearViewModel
import com.mrwinston.deadcellscompanion.viewmodel.GearViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, GearRepositoryModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(repository: GearRepositoryImpl)
    fun inject(viewModel: GearViewModel)
    fun inject(fragment: GearInfoFragment)
    fun inject(fragment: GrenadesFragment)
    fun inject(fragment: MeleeWeaponsFragment)
    fun inject(fragment: PowersFragment)
    fun inject(fragment: RangedWeaponsFragment)
    fun inject(fragment: ShieldsFragment)
    fun inject(fragment: TrapsFragment)
    fun inject(fragment: WeaponsFragment)
    fun inject(viewModelFactory: GearViewModelFactory)
}