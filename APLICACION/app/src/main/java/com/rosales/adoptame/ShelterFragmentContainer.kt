package com.rosales.adoptame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rosales.adoptame.databinding.ActivityFragmentContainerBinding
import com.rosales.adoptame.databinding.ActivityShelterFragmentContainerBinding

class ShelterFragmentContainer : AppCompatActivity() {
    private lateinit var binding: ActivityShelterFragmentContainerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_shelter_fragment_container)


    }
}
