package com.rosales.adoptame.ui.servicecard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rosales.adoptame.R
import com.rosales.adoptame.databinding.ItemServicecardBinding
import com.rosales.adoptame.data.model.Service
import com.rosales.adoptame.ui.petcard.PetProfileFragment

class ServiceCardAdapter : RecyclerView.Adapter<ServiceCardAdapter.ServiceViewHolder>() {

    inner class ServiceViewHolder(private val binding: ItemServicecardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(service : Service) {
            binding.service = service
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ServiceViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_servicecard,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        services?.let {
            holder.bind(it[position])
        }

        holder.itemView.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val serviceProfile = ServiceProfileFragment( services !! [position])
                activity.supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_real,serviceProfile).addToBackStack(null).commit()
            }
        })
    }

    override fun getItemCount() = services?.size ?: 0

    private var services: List<Service>? = null

    fun setData(data: List<Service>) {
        services = data
        println(services)
        notifyDataSetChanged()

    }
}