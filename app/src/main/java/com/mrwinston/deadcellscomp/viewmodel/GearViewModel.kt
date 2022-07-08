package com.mrwinston.deadcellscomp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mrwinston.deadcellscomp.data.model.*
import com.mrwinston.deadcellscomp.data.repository.GearRepository
import javax.inject.Inject

/* View Model responsible for retrieving item data. */
class GearViewModel @Inject constructor(gearRepository: GearRepository) : ViewModel() {

    val meleeWeapons: LiveData<List<MeleeWeapon>> = gearRepository.provideMeleeWeapons()
    val rangedWeapons: LiveData<List<RangedWeapon>> = gearRepository.provideRangedWeapons()
    val shields: LiveData<List<Shield>> = gearRepository.provideShields()
    val grenades: LiveData<List<Grenade>> = gearRepository.provideGrenades()
    val traps: LiveData<List<TrapOrTurret>> = gearRepository.provideTraps()
    val powers: LiveData<List<Power>> = gearRepository.providePowers()
}