package com.rosales.adoptame.ui.servicecard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rosales.adoptame.R
import com.rosales.adoptame.data.model.Service

class ServiceProfileFragment(service: Service) : Fragment() {

    val serviceInfo = service

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTextView: TextView = view.findViewById(R.id.serviceName)
        val addressTextView: TextView = view.findViewById(R.id.serviceAddress)
        val emailTextView: TextView = view.findViewById(R.id.serviceEmail)
        val phoneTextView: TextView = view.findViewById(R.id.servicePhone)
        val descriptionTextView: TextView = view.findViewById(R.id.serviceDescription)

        nameTextView.text = serviceInfo.name.toString()
        addressTextView.text = serviceInfo.address.toString()
        emailTextView.text = serviceInfo.email.toString()
        phoneTextView.text = serviceInfo.phone.toString()
        descriptionTextView.text = serviceInfo.description.toString()
    }
}