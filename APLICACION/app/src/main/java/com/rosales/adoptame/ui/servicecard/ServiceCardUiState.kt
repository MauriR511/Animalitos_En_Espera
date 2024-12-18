package com.rosales.adoptame.ui.servicecard

import androidx.lifecycle.LiveData
import com.rosales.adoptame.data.model.Service


sealed class ServiceCardUiState {
    object Loading : ServiceCardUiState()
    class Error(val exception: Exception) : ServiceCardUiState()
    data class Success(val service: LiveData<List<Service>>) : ServiceCardUiState()
}

//Ya esta comleto