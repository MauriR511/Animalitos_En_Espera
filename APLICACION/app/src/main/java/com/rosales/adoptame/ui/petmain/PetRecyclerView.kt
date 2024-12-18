package com.rosales.adoptame.ui.petmain

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.rosales.adoptame.AdoptameApplication
import com.rosales.adoptame.R
import com.rosales.adoptame.databinding.FragmentPetCardListBinding
import com.rosales.adoptame.databinding.FragmentPetRecyclerViewBinding
import com.rosales.adoptame.ui.ViewModelFactory
import com.rosales.adoptame.ui.petcard.PetCardAdapter
import com.rosales.adoptame.ui.petcard.PetCardUiState
import com.rosales.adoptame.ui.petcard.PetCardViewModel


class PetRecyclerView : Fragment() {

    private val viewModelFactory by lazy {
        val application = requireActivity().application as AdoptameApplication
        ViewModelFactory(application.getPetCardRepository())
    }

    private val viewModel: PetMainViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var binding: FragmentPetRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pet_recycler_view, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val petListRecyclerView = binding.petCardMainRecycleView
        val petMainAdapter = PetMainAdapter()
        petListRecyclerView.apply {
            adapter = petMainAdapter
        }

        viewModel.getAllPets()

        viewModel.status.observe(viewLifecycleOwner) {status ->
            when (status){
                is PetMainUiState.Error -> Log.d("Pet List Status", "Error",status.exception)
                PetMainUiState.Loading -> Log.d("Pet List Status", "Loading")
                is PetMainUiState.Success -> handleSuccess(status, petMainAdapter)
            }
        }
    }

    private fun handleSuccess(status: PetMainUiState.Success, petmainadapter: PetMainAdapter) {
        status.pet.observe(viewLifecycleOwner){data ->
            petmainadapter.setData(data)
        }
    }

}