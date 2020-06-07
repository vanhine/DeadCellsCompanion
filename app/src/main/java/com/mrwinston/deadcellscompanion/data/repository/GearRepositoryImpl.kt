package com.mrwinston.deadcellscompanion.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.mrwinston.deadcellscompanion.data.model.*
import javax.inject.Inject

class GearRepositoryImpl @Inject constructor(val db: FirebaseFirestore) : GearRepository {

    override fun provideMeleeWeapons(): LiveData<List<MeleeWeapon>> {
        val meleeWeaponList = mutableListOf<MeleeWeapon>()
        val liveDataMeleeWeapon = MutableLiveData<List<MeleeWeapon>>()
        db.collection(MELEE_WEAPONS_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    meleeWeaponList.add(MeleeWeapon.documentToMeleeWeapon(document.data))
                }
                liveDataMeleeWeapon.postValue(meleeWeaponList)
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        return liveDataMeleeWeapon
    }

    override fun provideRangedWeapons(): LiveData<List<RangedWeapon>> {
        val rangedWeaponList = mutableListOf<RangedWeapon>()
        val liveDataRangedWeapon = MutableLiveData<List<RangedWeapon>>()
        db.collection(RANGED_WEAPONS_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    rangedWeaponList.add(RangedWeapon.documentToRangedWeapon(document.data))
                }
                liveDataRangedWeapon.postValue(rangedWeaponList)
            }
        return liveDataRangedWeapon
    }

    override fun provideShields(): LiveData<List<Shield>> {
        val shieldList = mutableListOf<Shield>()
        val liveDataShields = MutableLiveData<List<Shield>>()
        db.collection(SHIELDS_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    shieldList.add(Shield.documentToShield(document.data))
                }
                liveDataShields.postValue(shieldList)
            }
        return liveDataShields
    }

    override fun provideTraps(): LiveData<List<TrapOrTurret>> {
        val trapList = mutableListOf<TrapOrTurret>()
        val liveDataTraps = MutableLiveData<List<TrapOrTurret>>()
        db.collection(TRAPS_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    trapList.add(TrapOrTurret.documentToTrapOrTurret(document.data))
                }
                liveDataTraps.postValue(trapList)
            }
        return liveDataTraps
    }

    override fun provideGrenades(): LiveData<List<Grenade>> {
        val grenadeList = mutableListOf<Grenade>()
        val liveDataGrenades = MutableLiveData<List<Grenade>>()
        db.collection(GRENADES_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    grenadeList.add(Grenade.documentToItem(document.data))
                }
                liveDataGrenades.postValue(grenadeList)
            }
        return liveDataGrenades
    }

    override fun providePowers(): LiveData<List<Power>> {
        val powerList = mutableListOf<Power>()
        val liveDataPowers = MutableLiveData<List<Power>>()
        db.collection(POWERS_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    powerList.add(Power.documentToPower(document.data))
                }
                liveDataPowers.postValue(powerList)
            }
        return liveDataPowers
    }


    companion object {
        const val MELEE_WEAPONS_COLLECTION = "melee_weapons"
        const val RANGED_WEAPONS_COLLECTION = "ranged_weapons"
        const val SHIELDS_COLLECTION = "shields"
        const val GRENADES_COLLECTION = "grenades"
        const val TRAPS_COLLECTION = "traps"
        const val POWERS_COLLECTION = "powers"
        const val TAG = "GearRepositoryImpl"
    }
}