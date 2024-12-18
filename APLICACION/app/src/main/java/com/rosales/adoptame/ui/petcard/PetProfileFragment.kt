package com.rosales.adoptame.ui.petcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import com.rosales.adoptame.R
import com.rosales.adoptame.data.model.Pet

class PetProfileFragment(pet: Pet) : Fragment() {

    var petInfo = pet

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pet_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTextView: TextView = view.findViewById(R.id.petInfoName)
        val ageTextView: TextView = view.findViewById(R.id.petInfoAge)
        val addressTextView: TextView = view.findViewById(R.id.petInfoAddress)
        val personalityTextView: TextView = view.findViewById(R.id.petInfoPersonality)
        val historyTextView: TextView = view.findViewById(R.id.petInfoHistory)
        val specieTextView: TextView = view.findViewById(R.id.petInfoSpecies)
        val sizeTextView: TextView = view.findViewById(R.id.petInfoSize)
        val weightTextView: TextView = view.findViewById(R.id.petInfoWeight)
        val genderTextView: TextView = view.findViewById(R.id.petInfoGender)
        val birthdateTextView: TextView = view.findViewById(R.id.petInfoBirthDate)
        val vaccineTextView: TextView = view.findViewById(R.id.petInfoVaccine)
        val requirementsTextView: TextView = view.findViewById(R.id.petInfoRequirements)

        nameTextView.text = petInfo.name.toString()
        ageTextView.text = petInfo.age.toString()
        addressTextView.text = "CASA DE FLAMENCO"
        personalityTextView.text = petInfo.personality.toString()
        historyTextView.text = petInfo.history.toString()
        specieTextView.text = petInfo.specie.toString()
        sizeTextView.text = petInfo.size.toString()
        weightTextView.text = petInfo.weight.toString()
        genderTextView.text = petInfo.gender.toString()
        birthdateTextView.text = petInfo.birthdate.toString()
        vaccineTextView.text = petInfo.vaccine.toString()
        requirementsTextView.text = petInfo.adoptionRequirement.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}