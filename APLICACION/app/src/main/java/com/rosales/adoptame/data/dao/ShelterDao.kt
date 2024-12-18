package com.rosales.adoptame.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rosales.adoptame.data.model.Shelter

@Dao
interface ShelterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShelter(word: Shelter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShelter(words: List<Shelter>)

    @Query("SELECT * FROM Shelter_table")
    fun getAllShelterCards(): LiveData<List<Shelter>>

    @Update
    suspend fun updateShelter(word: Shelter)

    @Delete
    suspend fun deleteShelter(word: Shelter)
}