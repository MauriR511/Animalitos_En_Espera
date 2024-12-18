package com.rosales.adoptame.data.model

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

@Entity(tableName = "Pet_table")
data class Pet(
    @PrimaryKey @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: String,
    @ColumnInfo(name = "personality") val personality: String,
    @ColumnInfo(name = "vaccine") val vaccine: String,
    @ColumnInfo(name = "specie") val specie: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "weight") val weight: String,
    @ColumnInfo(name = "birthdate") val birthdate: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "history") val history: String,
    @ColumnInfo(name = "adoptionRequirement") val adoptionRequirement: String,
    // TODO: ARREGLAR TIPO DE DATOS TANTO EN APLICACION COMO EN API
    //@ColumnInfo(name = "photos") val photos: String,
    //@ColumnInfo(name = "videos") val videos: String,
   // @ColumnInfo(name = "userID") val userID: User,

    )
/*
class SourceTypeConverter {
    @TypeConverter
    fun fromSource(pet: Pet): String {
        return JSONObject().apply {
            put("vaccine", pet.vaccine)
            put("personality", pet.personality)
            put("photos", pet.photos)
            put("videos", pet.videos)
        }.toString()
    }

    @TypeConverter
    fun toSource(pet: String): Pet {
        val json = JSONObject(pet)
        return Pet (json.get(""), json.getString("name"))
    }
}
*/



/*
data class convertirPersonality(val personality: String)
data class convertirVaccine(val vaccine: String)
data class convertirPhotos(val photos: String)
data class convertirVideos(val videos: String)

class PersonalityTypeConverter {
    @TypeConverter
    fun listToJson(value: MutableList<convertirPersonality>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<convertirPersonality>::class.java).toMutableList()
}

class VaccineTypeConverter {
    @TypeConverter
    fun listToJson(value: MutableList<convertirVaccine>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<convertirVaccine>::class.java).toMutableList()
}

class PhotoTypeConverter {
    @TypeConverter
    fun listToJson(value: MutableList<convertirPhotos>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<convertirPhotos>::class.java).toMutableList()
}

class VideosTypeConverter {
    @TypeConverter
    fun listToJson(value: MutableList<convertirVideos>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<convertirVideos>::class.java).toMutableList()
}

*/
