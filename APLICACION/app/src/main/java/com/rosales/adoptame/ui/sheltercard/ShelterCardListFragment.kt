package com.rosales.adoptame.ui.sheltercard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rosales.adoptame.AdoptameApplication
import com.rosales.adoptame.R
import com.rosales.adoptame.databinding.FragmentShelterCardListBinding
import com.rosales.adoptame.ui.ViewModelFactory


class ShelterCardListFragment : Fragment() {

    private val viewModelFactory by lazy {
        val application = requireActivity().application as AdoptameApplication
        ViewModelFactory(application.getShelterCardRepository())
    }
    private val viewModel: ShelterCardViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var binding: FragmentShelterCardListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shelter_card_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shelterListRecyclerView = binding.Shelterlistrecyclerview
        val shelterCardAdapter = ShelterCardAdapter()
        shelterListRecyclerView.apply {
            adapter = shelterCardAdapter
        }

        viewModel.getAllServices()

        viewModel.status.observe(viewLifecycleOwner) {status ->
            when (status){
                is ShelterCardUiState.Error -> Log.d("Shelter List Status", "Error",status.exception)
                ShelterCardUiState.Loading -> Log.d("Shelter List Status", "Loading")
                is ShelterCardUiState.Success -> handleSuccess(status, shelterCardAdapter)
            }
        }
    }

    private fun handleSuccess(status: ShelterCardUiState.Success, shelterAdapter: ShelterCardAdapter) {
        status.service.observe(viewLifecycleOwner){data ->
            shelterAdapter.setData(data)
        }
    }
}