package com.rosales.adoptame.ui.petPost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rosales.adoptame.network.ApiResponse
import com.rosales.adoptame.repository.PetPostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PetPostViewModel (private val repository: PetPostRepository) : ViewModel() {
    val nameField = MutableLiveData("")
    val ageField = MutableLiveData("")
    val personalityField = MutableLiveData("")
    val vaccineField = MutableLiveData ("")
    val specieField = MutableLiveData("")
    val sizeField = MutableLiveData("")
    val weightField = MutableLiveData("")
    val birthdateField = MutableLiveData("")
    val genderField = MutableLiveData("")
    val historyField = MutableLiveData("")
    val adoptionRequirementField = MutableLiveData("")

    private val _status = MutableLiveData<PetPostUiStatus>(PetPostUiStatus.Resume)
    val status: LiveData<PetPostUiStatus>
        get() = _status


    fun petWrite(){
        _status.value = PetPostUiStatus.Loading //.loading
        viewModelScope.launch(Dispatchers.IO) {
            _status.postValue(
                when(val response = repository.RegisterPet(
                    nameField.value.toString(),
                    ageField.value.toString(),
                    personalityField.value.toString(),
                    vaccineField.value.toString(),
                    specieField.value.toString(),
                    sizeField.value.toString(),
                    weightField.value.toString(),
                    birthdateField.value.toString(),
                    genderField.value.toString(),
                    historyField.value.toString(),
                    adoptionRequirementField.value.toString()


                )) {
                    is ApiResponse.Error -> PetPostUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> PetPostUiStatus.Resume //TODO: Modificar el estado para permitir errores con mensajes
                    is ApiResponse.Success -> PetPostUiStatus.Success(response.data )
                }
            )
        }
    }
}