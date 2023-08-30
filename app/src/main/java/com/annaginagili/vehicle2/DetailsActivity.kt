package com.annaginagili.vehicle2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.annaginagili.vehicle2.databinding.ActivityDetailsBinding
import com.annaginagili.vehicle2.databinding.ActivityMainBinding
import com.annaginagili.vehicle2.databinding.VehicleLayoutBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.observeVehicleLiveData().observe(this) {
            binding.viewData = it.Results[0]
        }
        viewModel.getVehicleByName(intent.getStringExtra("name")!!)
    }
}