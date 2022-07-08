package com.mrwinston.deadcellsref.data.repository

import androidx.lifecycle.LiveData
import com.mrwinston.deadcellsref.data.model.*

interface GearRepository {
    fun provideMeleeWeapons(): LiveData<List<MeleeWeapon>>
    fun provideRangedWeapons(): LiveData<List<RangedWeapon>>
    fun provideShields(): LiveData<List<Shield>>
    fun provideTraps(): LiveData<List<TrapOrTurret>>
    fun provideGrenades(): LiveData<List<Grenade>>
    fun providePowers(): LiveData<List<Power>>
}