package com.rosales.adoptame.ui.sheltermain

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
import com.rosales.adoptame.databinding.FragmentShelterCardListBinding
import com.rosales.adoptame.databinding.FragmentShelterMainBinding
import com.rosales.adoptame.ui.ViewModelFactory
import com.rosales.adoptame.ui.sheltercard.ShelterCardAdapter
import com.rosales.adoptame.ui.sheltercard.ShelterCardUiState
import com.rosales.adoptame.ui.sheltercard.ShelterCardViewModel


class ShelterMainFragment : Fragment() {

    private val viewModelFactory by lazy {
        val application = requireActivity().application as AdoptameApplication
        ViewModelFactory(application.getShelterCardRepository())
    }
    private val viewModel: ShelterMainViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var binding: FragmentShelterMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shelter_main,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shelterListRecyclerView = binding.shelterCardMainRecycleView
        val shelterMainAdapter = ShelterMainAdapter()
        shelterListRecyclerView.apply {
            adapter = shelterMainAdapter
        }

        viewModel.getAllServices()

        viewModel.status.observe(viewLifecycleOwner) {status ->
            when (status){
                is ShelterCardUiState.Error -> Log.d("Shelter List Status", "Error",status.exception)
                ShelterCardUiState.Loading -> Log.d("Shelter List Status", "Loading")
                is ShelterCardUiState.Success -> handleSuccess(status, shelterMainAdapter)
            }
        }
    }

    private fun handleSuccess(status: ShelterCardUiState.Success, shelterMainAdapter: ShelterMainAdapter) {
        status.service.observe(viewLifecycleOwner){data ->
            shelterMainAdapter.setData(data)
        }
    }
}



