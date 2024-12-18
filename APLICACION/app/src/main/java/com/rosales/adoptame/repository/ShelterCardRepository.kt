package com.rosales.adoptame.repository

import androidx.lifecycle.LiveData
import com.rosales.adoptame.data.AdoptameDataBase
import com.rosales.adoptame.data.model.Shelter
import com.rosales.adoptame.network.AdoptameService
import com.rosales.adoptame.network.ApiResponse

import retrofit2.HttpException
import java.io.IOException

class ShelterCardRepository (
    database: AdoptameDataBase,
    private val api: AdoptameService
) {
    private val shelterDoa = database.shelterDao()

    suspend fun getAllShelterCards(): ApiResponse<LiveData<List<Shelter>>> {
        return try {

            val response = api.getAllShelters()
            println("Imprimiendo el response de Shelter" + response)
            //Use database as cache
            if (response.count > 0) {
                shelterDoa.insertShelter(response.shelters)

            }
            ApiResponse.Success(data = shelterDoa.getAllShelterCards())
        } catch (e: HttpException) {
            //handles exception with the request
            ApiResponse.Error(exception = e)
        } catch (e: IOException) {
            //handles no internet exception
            ApiResponse.Error(exception = e)
        }
    }
}
