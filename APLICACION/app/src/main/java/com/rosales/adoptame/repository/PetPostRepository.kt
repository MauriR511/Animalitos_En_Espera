package com.rosales.adoptame.repository

import com.rosales.adoptame.data.model.Pet
import com.rosales.adoptame.data.model.User
import com.rosales.adoptame.network.AdoptameService
import com.rosales.adoptame.network.ApiResponse
import com.rosales.adoptame.network.dto.PetPostRequest
import com.rosales.adoptame.network.dto.RegisterRequest
import retrofit2.HttpException
import java.io.IOException

class PetPostRepository (private val api: AdoptameService) {
    suspend fun RegisterPet(
        name:String,
        age: String,
        personality: String,
        vaccine: String,
        specie: String,
        size: String,
        weight: String,
        birthdate: String,
        gender: String,
        history: String,
        adoptionRequirement: String
    ): ApiResponse<Pet> {
        try {
            val response = api.petPost(PetPostRequest(name,age,personality,vaccine,specie,size,weight,birthdate,gender,history,adoptionRequirement))
            val pet = Pet(

                response.name,
                response.age,
                response.personality,
                response.vaccine,
                response.specie,
                response.size,
                response.weight,
                response.birthdate,
                response.gender,
                response.history,
                response.adoptionRequirement,

                )
            return ApiResponse.Success(
                pet
            )
        } catch (e: HttpException){
            if (e.code() == 400){
                //TODO: FALTA CONVERTIR EL BODY A UN OBJETO KOTLIN
                return ApiResponse.ErrorWithMessage(e.response()?.body().toString())
            }
            return ApiResponse.Error(e)
        } catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }
}