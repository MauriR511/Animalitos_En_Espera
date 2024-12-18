package com.rosales.adoptame.ui.sheltercard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rosales.adoptame.R
import com.rosales.adoptame.data.model.Shelter


class ShelterProfileFragment(shelter: Shelter) : Fragment() {

    val shelterInfo = shelter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shelter_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTextView: TextView = view.findViewById(R.id.shelterName)
        val addressTextView: TextView = view.findViewById(R.id.shelterAddress)
        val emailTextView: TextView = view.findViewById(R.id.shelterEmail)
        val phoneTextView: TextView = view.findViewById(R.id.shelterPhone)
        val descriptionTextView: TextView = view.findViewById(R.id.shelterDescription)
        val webSiteTextView: TextView = view.findViewById(R.id.shelterWebsite)

        nameTextView.text = shelterInfo.name.toString()
        addressTextView.text = shelterInfo.address.toString()
        emailTextView.text = shelterInfo.email.toString()
        phoneTextView.text = shelterInfo.phone.toString()
        descriptionTextView.text = shelterInfo.description.toString()
        webSiteTextView.text = shelterInfo.website.toString()
    }
}