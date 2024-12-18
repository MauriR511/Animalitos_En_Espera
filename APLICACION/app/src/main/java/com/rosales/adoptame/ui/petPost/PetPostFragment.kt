package com.rosales.adoptame.ui.petPost

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rosales.adoptame.AdoptameApplication
import com.rosales.adoptame.R
import com.rosales.adoptame.databinding.FragmentPetPostBinding
import com.rosales.adoptame.ui.ViewModelFactory



class PetPostFragment : AppCompatActivity() {
    private lateinit var binding: FragmentPetPostBinding
    private val app by lazy {
        application as AdoptameApplication
    }
    private  val viewModelFactory by lazy {
        ViewModelFactory(app.getPetPostRepository())
    }
    private val petViewmodel: PetPostViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.fragment_pet_post)
        binding.petViewModel = petViewmodel


        petViewmodel.status.observe(this) {
                status -> handleUiState(status)
        }
        binding.CreatePetbttn.setOnClickListener {

            petViewmodel.petWrite()

        }
    }



    private fun handleUiState(status: PetPostUiStatus){
        when (status){
            is PetPostUiStatus.Error -> Log.d("Login List Status","Error")
            PetPostUiStatus.Loading -> Log.d("Login List Status","Loading")
            PetPostUiStatus.Resume -> Log.d("Login List Status","Resume")
            is PetPostUiStatus.Success -> {
                Log.d("Login List Status","Animal registrado")
            }
        }
    }
}