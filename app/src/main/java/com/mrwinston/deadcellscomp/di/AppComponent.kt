package com.mrwinston.deadcellscomp.di

import com.mrwinston.deadcellscomp.data.repository.GearRepositoryImpl
import com.mrwinston.deadcellscomp.view.MainActivity
import com.mrwinston.deadcellscomp.view.fragments.*
import com.mrwinston.deadcellscomp.viewmodel.GearViewModel
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
    fun inject(fragment: GrenadesFragment)
    fun inject(fragment: MeleeWeaponsFragment)
    fun inject(fragment: PowersFragment)
    fun inject(fragment: RangedWeaponsFragment)
    fun inject(fragment: ShieldsFragment)
    fun inject(fragment: TrapsFragment)
    fun inject(fragment: WeaponsFragment)
}