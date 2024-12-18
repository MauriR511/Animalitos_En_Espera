package com.rosales.adoptame.ui.petPost

import com.rosales.adoptame.data.model.Pet


sealed class PetPostUiStatus {
    object Resume : PetPostUiStatus()
    object Loading : PetPostUiStatus()
    class Error(val exception: Exception) : PetPostUiStatus()
    data class Success(
        val pet: Pet
    ) : PetPostUiStatus()
}