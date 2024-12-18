package com.rosales.adoptame.ui.servicecard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rosales.adoptame.network.ApiResponse
import com.rosales.adoptame.repository.ServiceCardRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiceCardViewModel(private val repository: ServiceCardRepository) : ViewModel() {

    //by default
    private val _status = MutableLiveData<ServiceCardUiState>(ServiceCardUiState.Loading)
    val status: LiveData<ServiceCardUiState>
        get() = _status

    fun getAllServices() {
        _status.value = ServiceCardUiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            _status.postValue(
                when (val response = repository.getAllServiceCards()) {
                    is ApiResponse.Error -> ServiceCardUiState.Error(response.exception)
                    is ApiResponse.Success -> ServiceCardUiState.Success(response.data)
                    is ApiResponse.ErrorWithMessage -> TODO()
                }
            )
        }
    }
}

//Ya esta cambiado