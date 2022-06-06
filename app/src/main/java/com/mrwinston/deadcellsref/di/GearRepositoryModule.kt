package com.mrwinston.deadcellsref.di

import com.mrwinston.deadcellsref.data.repository.GearRepository
import com.mrwinston.deadcellsref.data.repository.GearRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class GearRepositoryModule {
    @Binds
    abstract fun provideRepository(repositoryImpl: GearRepositoryImpl): GearRepository
}