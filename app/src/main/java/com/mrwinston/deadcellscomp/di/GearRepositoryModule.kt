package com.mrwinston.deadcellscomp.di

import com.mrwinston.deadcellscomp.data.repository.GearRepository
import com.mrwinston.deadcellscomp.data.repository.GearRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class GearRepositoryModule {
    @Binds
    abstract fun provideRepository(repositoryImpl: GearRepositoryImpl): GearRepository
}