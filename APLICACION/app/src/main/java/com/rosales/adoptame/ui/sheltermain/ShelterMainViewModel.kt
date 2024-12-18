package com.rosales.adoptame.ui.sheltermain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rosales.adoptame.network.ApiResponse
import com.rosales.adoptame.repository.ShelterCardRepository
import com.rosales.adoptame.ui.sheltercard.ShelterCardUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShelterMainViewModel(private val repository: ShelterCardRepository) : ViewModel() {

    //by default
    private val _status = MutableLiveData<ShelterCardUiState>(ShelterCardUiState.Loading)
    val status: LiveData<ShelterCardUiState>
        get() = _status

    fun getAllServices() {
        _status.value = ShelterCardUiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            _status.postValue(
                when (val response = repository.getAllShelterCards()) {
                    is ApiResponse.Error -> ShelterCardUiState.Error(response.exception)
                    is ApiResponse.Success -> ShelterCardUiState.Success(response.data)
                    is ApiResponse.ErrorWithMessage -> TODO()
                }
            )
        }
    }
}