package com.rosales.adoptame.ui.petmain

import androidx.lifecycle.LiveData
import com.rosales.adoptame.data.model.Pet

sealed class PetMainUiState {
    object Loading: PetMainUiState()
    class Error(val exception: Exception) : PetMainUiState()
    data class Success(val pet: LiveData<List<Pet>>) : PetMainUiState()
}