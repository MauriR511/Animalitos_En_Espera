package com.rosales.adoptame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rosales.adoptame.databinding.ActivityFragmentContainerBinding
import com.rosales.adoptame.databinding.ActivityServiceFragmentContainerBinding

class ServiceFragmentContainer : AppCompatActivity() {
    private lateinit var binding: ActivityServiceFragmentContainerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_fragment_container)

    }
}