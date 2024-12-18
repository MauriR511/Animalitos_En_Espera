package com.rosales.adoptame.ui.sheltermain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rosales.adoptame.R
import com.rosales.adoptame.data.model.Shelter
import com.rosales.adoptame.databinding.ItemSheltercardBinding
import com.rosales.adoptame.databinding.ShelterCardMainLayoutBinding
import com.rosales.adoptame.ui.sheltercard.ShelterCardAdapter
import com.rosales.adoptame.ui.sheltercard.ShelterProfileFragment

class ShelterMainAdapter : RecyclerView.Adapter<ShelterMainAdapter.ShelterMainViewHolder>() {
    inner class ShelterMainViewHolder (private val binding: ShelterCardMainLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind (shelter : Shelter){
            binding.shelter = shelter
            binding.executePendingBindings()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ShelterMainViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.shelter_card_main_layout,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ShelterMainAdapter.ShelterMainViewHolder, position: Int) {
        shelters?.let {
            holder.bind(it[position])
        }

        holder.itemView.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val shelterProfile = ShelterProfileFragment( shelters !! [position])
                activity.supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_real,shelterProfile).addToBackStack(null).commit()
            }
        })
    }

    override fun getItemCount() = shelters?.size ?: 0

    private var shelters: List<Shelter>? = null

    fun setData(data: List<Shelter>) {
        shelters = data
        println(shelters)
        notifyDataSetChanged()

    }
}