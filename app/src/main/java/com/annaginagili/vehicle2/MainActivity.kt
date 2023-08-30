package com.annaginagili.vehicle2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.annaginagili.vehicle2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: VehicleAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModel
    private lateinit var input: EditText
    private lateinit var search: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        recycler = binding.recycler
        input = binding.input
        search = binding.search

        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.observeVehicleLiveData().observe(this) {
            recycler.setHasFixedSize(true)
            recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = VehicleAdapter(this, it.Results)
            recycler.adapter = adapter
        }
        viewModel.getVehicle()

        search.setOnClickListener {
            if (input.text.isNotEmpty()) {
                val intent1 = Intent(this, SearchActivity::class.java)
                intent1.putExtra("name", input.text.toString())
                startActivity(intent1)
            }
        }
    }
}