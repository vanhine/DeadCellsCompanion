package com.mrwinston.deadcellscompanion.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mrwinston.deadcellscompanion.data.model.*
import com.mrwinston.deadcellscompanion.data.repository.GearRepository
import javax.inject.Inject

class GearViewModel @Inject constructor(gearRepository: GearRepository) : ViewModel() {

    val meleeWeapons: LiveData<List<MeleeWeapon>> = gearRepository.provideMeleeWeapons()
    val rangedWeapons: LiveData<List<RangedWeapon>> = gearRepository.provideRangedWeapons()
    val shields: LiveData<List<Shield>> = gearRepository.provideShields()
    val grenades: LiveData<List<Grenade>> = gearRepository.provideGrenades()
    val traps: LiveData<List<TrapOrTurret>> = gearRepository.provideTraps()
    val powers: LiveData<List<Power>> = gearRepository.providePowers()
}