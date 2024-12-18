package com.rosales.adoptame.ui.sheltercard

import androidx.lifecycle.LiveData
import com.rosales.adoptame.data.model.Shelter


sealed class ShelterCardUiState {
    object Loading : ShelterCardUiState()
    class Error(val exception: Exception) : ShelterCardUiState()
    data class Success(val service: LiveData<List<Shelter>>) : ShelterCardUiState()
}
