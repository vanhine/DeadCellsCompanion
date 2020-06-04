package com.mrwinston.deadcellscompanion.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mrwinston.deadcellscompanion.data.repository.GearRepository
import com.mrwinston.deadcellscompanion.util.adapters.GearItemAdapter
import com.mrwinston.deadcellscompanion.viewmodel.GearViewModel
import com.mrwinston.deadcellscompanion.viewmodel.GearViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    companion object {
        @Provides
        fun provideGearViewModel(repository: GearRepository): GearViewModel =
            GearViewModel(repository)

        @Provides
        fun providesGearViewModelFactory(): GearViewModelFactory = GearViewModelFactory()

        @Provides
        fun provideGearRepository(firebaseFirestore: FirebaseFirestore): GearRepository =
            GearRepository(firebaseFirestore)

        @Provides
        fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

        @Provides
        fun provideGearItemAdapter(): GearItemAdapter = GearItemAdapter()

        @Provides
        fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
    }
}