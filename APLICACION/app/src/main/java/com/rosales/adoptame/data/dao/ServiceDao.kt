package com.rosales.adoptame.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rosales.adoptame.data.model.Service

@Dao
interface ServiceDao {

    @Query("SELECT * FROM Service_table")
    fun getAllServiceCards(): LiveData<List<Service>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Service)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertService(services: List<Service>)

    @Update
    suspend fun updateWord(word: Service)

    @Delete
    suspend fun deleteWord(word: Service)
}