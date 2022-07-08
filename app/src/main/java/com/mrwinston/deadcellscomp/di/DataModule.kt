package com.mrwinston.deadcellscomp.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mrwinston.deadcellscomp.data.repository.GearRepositoryImpl
import com.mrwinston.deadcellscomp.util.adapters.GearItemAdapter
import com.mrwinston.deadcellscomp.viewmodel.GearViewModel
import com.mrwinston.deadcellscomp.viewmodel.GearViewModelFactory
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