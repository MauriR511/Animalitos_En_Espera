package com.rosales.adoptame

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.rosales.adoptame.data.AdoptameDataBase
import com.rosales.adoptame.network.RetrofitInstance
import com.rosales.adoptame.repository.*

class AdoptameApplication: Application() {
    private val prefs: SharedPreferences by lazy {
        getSharedPreferences("Adoptame", Context.MODE_PRIVATE)
    }

    private val dataBase by lazy{
        AdoptameDataBase.getInstance(this)
    }

    private fun getAPIService() = with(RetrofitInstance) {
        setToken(getToken())
        getAdoptameService()
    }

    fun getPetCardRepository() =
        PetCardRepository(dataBase,getAPIService())

    fun getServiceCardRepository() =
        ServiceCardRepository(dataBase,getAPIService())

    fun getShelterCardRepository() =
        ShelterCardRepository(dataBase,getAPIService())

    fun getLoginRepository() =
        LoginRepository(getAPIService())

    fun getRegisterRepository() =
        RegisterRepository(getAPIService())

    fun getPetPostRepository() =
        PetPostRepository(getAPIService())

    fun getCreateShelterRepository() =
        PetPostRepository(getAPIService())

    fun getCreateServiceRepository() =
        PetPostRepository(getAPIService())

    private fun getToken(): String = prefs.getString(USER_TOKEN,"")!!

    fun isUserLogin() = getToken() != ""

    fun saveAuthToken(token: String){
        val editor = prefs.edit()
        editor.putString(USER_TOKEN,token)
        editor.apply()
    }

    companion object{
        const val USER_TOKEN = "user_token"
    }
}