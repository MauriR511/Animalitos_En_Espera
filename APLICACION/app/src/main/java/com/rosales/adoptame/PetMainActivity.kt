package com.rosales.adoptame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.rosales.adoptame.databinding.PetCardMainLayoutBinding
import com.rosales.adoptame.ui.ViewModelFactory
import com.rosales.adoptame.ui.petcard.PetCardListFragment
import com.rosales.adoptame.ui.servicecard.ServiceCardListFragment


class PetMainActivity : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_pet_main_activity, container, false)
        val seeMoreButton: ImageView = view.findViewById(R.id.seeMorePets)
        val seeMoreShelter: ImageView = view.findViewById(R.id.seeMoreShelters)
        val seeMoreServices: ImageView = view.findViewById(R.id.seeMoreServices)
        seeMoreButton.setOnClickListener{
            val fragment = PetCardListFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_real, fragment)?.commit()
        }

        seeMoreShelter.setOnClickListener{
            val fragment = ServiceCardListFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_real, fragment)?.commit()
        }

        seeMoreServices.setOnClickListener{
            val fragment = ServiceCardListFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment_real, fragment)?.commit()
        }


        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}