package com.rosales.adoptame.repository

import androidx.lifecycle.LiveData
import com.rosales.adoptame.data.AdoptameDataBase
import com.rosales.adoptame.data.model.Service
import com.rosales.adoptame.network.AdoptameService
import com.rosales.adoptame.network.ApiResponse

import retrofit2.HttpException
import java.io.IOException

class ServiceCardRepository(
    database: AdoptameDataBase,
    private val api: AdoptameService
) {
    private val serviceDoa = database.serviceDao()

    suspend fun getAllServiceCards(): ApiResponse<LiveData<List<Service>>> {
        return try {

            val response = api.getAllServices()
            println("Imprimiendo el response de Service" + response)
            //Use database as cache
            if (response.count > 0) {
                serviceDoa.insertService(response.services)

            }
            ApiResponse.Success(data = serviceDoa.getAllServiceCards())
        } catch (e: HttpException) {
            //handles exception with the request
            ApiResponse.Error(exception = e)
        } catch (e: IOException) {
            //handles no internet exception
            ApiResponse.Error(exception = e)
        }
    }
}
