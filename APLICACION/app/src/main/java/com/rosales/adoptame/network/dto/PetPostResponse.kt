package com.rosales.adoptame.network.dto

data class PetPostResponse (
   val name:String,
   val age: String,
   val personality: String,
   val vaccine: String,
   val specie: String,
   val size: String,
   val weight: String,
   val birthdate: String,
   val gender: String,
   val history: String,
   val adoptionRequirement: String
   )