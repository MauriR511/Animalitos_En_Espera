package com.rosales.adoptame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.rosales.adoptame.databinding.ActivityFragmentContainerBinding

class PetFragmentContainer : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentContainerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_container)


    }
}