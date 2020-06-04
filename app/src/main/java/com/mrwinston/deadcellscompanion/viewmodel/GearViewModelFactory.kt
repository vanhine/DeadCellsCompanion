package com.mrwinston.deadcellscompanion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrwinston.deadcellscompanion.data.repository.GearRepository
import javax.inject.Inject

class GearViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject
    lateinit var repository: GearRepository

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GearViewModel::class.java)) {
            return GearViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}