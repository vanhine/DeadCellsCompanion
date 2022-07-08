package com.mrwinston.deadcellscomp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.FirebaseFirestore
import com.mrwinston.deadcellscomp.data.model.*
import javax.inject.Inject

/**
 * Repository which retrieves data from the Firestore.
 *
 * @param db the Firestore to retrieve the data from.
 */
class GearRepositoryImpl @Inject constructor(val db: FirebaseFirestore) : GearRepository {

    private val failureListener: OnFailureListener = OnFailureListener { exception ->
        Log.d(TAG, "Error getting documents: ", exception)
    }

    /**
     * Retrieves all Melee Weapons from the database.
     *
     * @return LiveData list of [MeleeWeapon]s
     */
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
            .addOnFailureListener(failureListener)
        return liveDataMeleeWeapon
    }

    /**
     * Retrieves all Melee Weapons from the database.
     *
     * @return LiveData list of [RangedWeapon]s
     */
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
            .addOnFailureListener(failureListener)
        return liveDataRangedWeapon
    }

    /**
     * Retrieves all Melee Weapons from the database.
     *
     * @return LiveData list of [Shield]s
     */
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
            .addOnFailureListener(failureListener)
        return liveDataShields
    }

    /**
     * Retrieves all Melee Weapons from the database.
     *
     * @return LiveData list of [TrapOrTurret]s
     */
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
            .addOnFailureListener(failureListener)
        return liveDataTraps
    }

    /**
     * Retrieves all Melee Weapons from the database.
     *
     * @return LiveData list of [Grenade]s
     */
    override fun provideGrenades(): LiveData<List<Grenade>> {
        val grenadeList = mutableListOf<Grenade>()
        val liveDataGrenades = MutableLiveData<List<Grenade>>()
        db.collection(GRENADES_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    grenadeList.add(Grenade.documentToGrenade(document.data))
                }
                liveDataGrenades.postValue(grenadeList)
            }
            .addOnFailureListener(failureListener)
        return liveDataGrenades
    }

    /**
     * Retrieves all Melee Weapons from the database.
     *
     * @return LiveData list of [Power]s
     */
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
            .addOnFailureListener(failureListener)
        return liveDataPowers
    }


    companion object {
        private const val MELEE_WEAPONS_COLLECTION = "melee_weapons"
        private const val RANGED_WEAPONS_COLLECTION = "ranged_weapons"
        private const val SHIELDS_COLLECTION = "shields"
        private const val GRENADES_COLLECTION = "grenades"
        private const val TRAPS_COLLECTION = "traps"
        private const val POWERS_COLLECTION = "powers"
        private const val TAG = "GearRepositoryImpl"
    }
}