package com.rosales.adoptame.ui.servicemain

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
import com.rosales.adoptame.databinding.FragmentServiceMainBinding
import com.rosales.adoptame.databinding.FragmentServicecardListBinding
import com.rosales.adoptame.ui.ViewModelFactory
import com.rosales.adoptame.ui.servicecard.ServiceCardAdapter
import com.rosales.adoptame.ui.servicecard.ServiceCardUiState
import com.rosales.adoptame.ui.servicecard.ServiceCardViewModel


class ServiceMainFragment : Fragment() {
    private val viewModelFactory by lazy {
        val application = requireActivity().application as AdoptameApplication
        ViewModelFactory(application.getServiceCardRepository())
    }
    private val viewModel: ServiceMainViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var binding: FragmentServiceMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_service_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val serviceListRecyclerView = binding.serviceCardMainRecycleView
        val serviceMainAdapter = ServiceMainAdapter()
        serviceListRecyclerView.apply {
            adapter = serviceMainAdapter
        }

        viewModel.getAllServices()

        viewModel.status.observe(viewLifecycleOwner) {status ->
            when (status){
                is ServiceCardUiState.Error -> Log.d("Service List Status", "Error",status.exception)
                ServiceCardUiState.Loading -> Log.d("Service List Status", "Loading")
                is ServiceCardUiState.Success -> handleSuccess(status, serviceMainAdapter)
            }
        }
    }

    private fun handleSuccess(status: ServiceCardUiState.Success, serviceMainAdapter: ServiceMainAdapter) {
        status.service.observe(viewLifecycleOwner){data ->
            serviceMainAdapter.setData(data)
        }
    }
}