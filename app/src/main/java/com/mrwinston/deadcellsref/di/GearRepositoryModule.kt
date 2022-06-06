package com.mrwinston.deadcellscompanion.di

import com.mrwinston.deadcellscompanion.data.repository.GearRepository
import com.mrwinston.deadcellscompanion.data.repository.GearRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class GearRepositoryModule {
    @Binds
    abstract fun provideRepository(repositoryImpl: GearRepositoryImpl): GearRepository
}