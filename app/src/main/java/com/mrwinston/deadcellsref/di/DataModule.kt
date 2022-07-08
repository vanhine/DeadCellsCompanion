package com.mrwinston.deadcellsref.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mrwinston.deadcellsref.data.repository.GearRepositoryImpl
import com.mrwinston.deadcellsref.util.adapters.GearItemAdapter
import com.mrwinston.deadcellsref.viewmodel.GearViewModel
import com.mrwinston.deadcellsref.viewmodel.GearViewModelFactory
import dagger.Module
import dagger.Provides

@Module
abstract class DataModule {
    companion object {
        @Provides
        fun provideGearViewModel(repository: GearRepositoryImpl): GearViewModel =
            GearViewModel(repository)

        @Provides
        fun providesGearViewModelFactory(): GearViewModelFactory = GearViewModelFactory()

        @Provides
        fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

        @Provides
        fun provideGearItemAdapter(): GearItemAdapter = GearItemAdapter()

        @Provides
        fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
    }
}