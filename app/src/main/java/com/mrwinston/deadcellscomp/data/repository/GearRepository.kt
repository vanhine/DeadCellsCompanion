package com.mrwinston.deadcellscomp.data.repository

import androidx.lifecycle.LiveData
import com.mrwinston.deadcellscomp.data.model.*

interface GearRepository {
    fun provideMeleeWeapons(): LiveData<List<MeleeWeapon>>
    fun provideRangedWeapons(): LiveData<List<RangedWeapon>>
    fun provideShields(): LiveData<List<Shield>>
    fun provideTraps(): LiveData<List<TrapOrTurret>>
    fun provideGrenades(): LiveData<List<Grenade>>
    fun providePowers(): LiveData<List<Power>>
}