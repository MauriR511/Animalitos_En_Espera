package com.rosales.adoptame.network

import com.rosales.adoptame.network.dto.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AdoptameService {

    @POST("/login")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse

    @POST("/register")
    suspend fun register(@Body credentials: RegisterRequest): RegisterResponse

    @POST("/pet")
    suspend fun petPost(@Body credentials: PetPostRequest):  PetPostResponse

    @GET("/pet")
    suspend fun getAllPet(): PetCardResponse

    @GET("/service")
    suspend fun getAllServices(): ServiceCardResponse

    @GET("/shelter")
    suspend fun getAllShelters(): ShelterCardResponse


}