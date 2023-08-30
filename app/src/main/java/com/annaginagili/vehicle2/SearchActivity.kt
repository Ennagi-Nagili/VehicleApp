package com.annaginagili.vehicle2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.annaginagili.vehicle2.databinding.ActivityMainBinding
import com.annaginagili.vehicle2.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    private lateinit var binding: ActivitySearchBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        recycler = binding.recycler

        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.observeVehicleLiveData().observe(this) {
            recycler.setHasFixedSize(true)
            recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            val adapter = DetailsAdapter(this, it.Results)
            recycler.adapter = adapter
        }
        viewModel.getManuByName(intent.getStringExtra("name")!!)
    }
}