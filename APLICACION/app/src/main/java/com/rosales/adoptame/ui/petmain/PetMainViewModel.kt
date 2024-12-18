package com.rosales.adoptame.ui.petmain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rosales.adoptame.network.ApiResponse
import com.rosales.adoptame.repository.PetCardRepository
import com.rosales.adoptame.ui.petmain.PetMainUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PetMainViewModel(private val repository: PetCardRepository): ViewModel() {

    //by default
    private val _status = MutableLiveData<PetMainUiState>(PetMainUiState.Loading)
    val status: LiveData<PetMainUiState>
        get() = _status

    fun getAllPets() {
        _status.value = PetMainUiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            _status.postValue(
                when (val response = repository.getAllPetCards()){
                    is ApiResponse.Error -> PetMainUiState.Error(response.exception)
                    is ApiResponse.Success -> PetMainUiState.Success(response.data)
                    is ApiResponse.ErrorWithMessage -> TODO()
                }
            )
        }
    }
}