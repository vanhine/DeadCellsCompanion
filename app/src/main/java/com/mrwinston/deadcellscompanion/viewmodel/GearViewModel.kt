package com.mrwinston.deadcellscompanion.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrwinston.deadcellscompanion.models.*
import com.mrwinston.deadcellscompanion.repository.GearRepository

class GearViewModel: ViewModel() {
    private val gearRepository: GearRepository = GearRepository()
    val meleeWeapons: LiveData<List<MeleeWeapon>> = gearRepository.provideMeleeWeapons()
    val rangedWeapons: LiveData<List<RangedWeapon>> = gearRepository.provideRangedWeapons()
    val shields: LiveData<List<Shield>> = gearRepository.provideShields()
    val grenades: LiveData<List<Grenade>> = gearRepository.provideGrenades()
    val traps: LiveData<List<TrapOrTurret>> = gearRepository.provideTraps()
    val powers: LiveData<List<Power>> = gearRepository.providePowers()
}