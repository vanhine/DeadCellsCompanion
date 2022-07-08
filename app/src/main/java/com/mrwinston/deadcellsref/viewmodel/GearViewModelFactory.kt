package com.mrwinston.deadcellsref.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrwinston.deadcellsref.data.repository.GearRepositoryImpl
import javax.inject.Inject

/* Factory used to provide GearViewModel. */
class GearViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject
    lateinit var repository: GearRepositoryImpl

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GearViewModel::class.java)) {
            return GearViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}